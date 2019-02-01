package ru.job4j.inpututput.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver2 {

    public static void main(String[] args) throws IOException {
        String dir = null;
        String zipName = null;
        ArrayList<String> exts = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                dir = args[++i];
            } else if (args[i].equals("-o")) {
                zipName = args[++i];
            } else if (args[i].equals("-e")) {
                zipName = args[++i];
            }
        }
        Archiver2 archiver = new Archiver2();
        archiver.toZip(dir, zipName, exts);
    }

    public void toZip(String dir, String zipName, List<String> exts) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
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
