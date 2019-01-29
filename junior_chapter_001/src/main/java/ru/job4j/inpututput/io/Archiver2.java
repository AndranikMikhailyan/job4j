package ru.job4j.inpututput.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver2 {

    public void toZip(String dir, List<String> exts) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(dir + ".zip"));
        File file = new File(dir);
        String prefix = file.getParent();
        Queue<File> files = new LinkedList<>(List.of(file));
        while (files.size() > 0) {
            if (files.peek().isFile()) {
                String fileName = files.peek().getPath().substring(prefix.length() + 1);
                exts.stream().forEach(s -> {
                    if (fileName.endsWith("." + s)) {
                        try {
                            archive(files.poll(), zipOut, fileName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else if (isEmptyDirectory(files.peek())) {
                zipOut.putNextEntry(new ZipEntry(files.poll().getName() + "/"));
                zipOut.closeEntry();
            } else {
                for (File nextFile : files.poll().listFiles()) {
                    String nextFileName = nextFile.getPath().substring(prefix.length() + 1);
                    if (nextFile.isDirectory()) {
                        if (isEmptyDirectory(nextFile)) {
                            zipOut.putNextEntry(new ZipEntry(nextFileName + "/"));
                            zipOut.closeEntry();
                        } else {
                            zipOut.putNextEntry(new ZipEntry(nextFileName + "/"));
                            zipOut.closeEntry();
                            files.add(nextFile);
                        }
                    } else {
                        exts.stream().forEach(s -> {
                            if (nextFileName.endsWith("." + s)) {
                                try {
                                    archive(nextFile, zipOut, nextFileName);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }
        zipOut.close();
    }

    private void archive(File src, ZipOutputStream zipOut, String entryName) throws IOException {
        zipOut.putNextEntry(new ZipEntry(entryName));
        try (InputStream in = new FileInputStream(src)) {
            byte[] buff = new byte[2048];
            while (in.read(buff) != -1) {
                zipOut.write(buff);
            }
        }
        zipOut.closeEntry();
    }

    private boolean isEmptyDirectory(File directory) {
        return directory.listFiles().length == 0;
    }
}
