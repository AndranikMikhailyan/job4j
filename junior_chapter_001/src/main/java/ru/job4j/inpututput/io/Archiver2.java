package ru.job4j.inpututput.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver2 {

    public static void main(String[] args) throws IOException {
        Args cmdArgs = new Args(args);
        Archiver2 archiver = new Archiver2();
        archiver.toZip(cmdArgs.getDir(), cmdArgs.getZipName(), cmdArgs.getExts());
    }

    public void toZip(String dir, String zipName, List<String> exts) throws IOException {
        ArrayList<File> filteredFiles = this.filter(dir, exts);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName));
        File file = new File(dir);
        String prefix = file.getParent();
        for (File f : filteredFiles) {
            String nextFileName = f.getPath().substring(prefix.length() + 1);
            if (f.isDirectory()) {
                zipOut.putNextEntry(new ZipEntry(nextFileName + "/"));
                zipOut.closeEntry();
            } else {
                archive(f, zipOut, nextFileName);
            }
        }
        zipOut.close();
    }

    private ArrayList<File> filter(String dir, List<String> exts) {
        ArrayList<File> filtered = new ArrayList<>();
        File file = new File(dir);
        Queue<File> queue = new LinkedList<>(List.of(file));
        while (queue.size() > 0) {
            File nextFile = queue.poll();
            if (nextFile.isDirectory()) {
                filtered.add(nextFile);
                if (!isEmptyDirectory(nextFile)) {
                    Arrays.stream(nextFile.listFiles()).forEach(next -> queue.add(next));
                }
            } else {
                for (String suff: exts) {
                    if (nextFile.getName().endsWith(suff)) {
                        filtered.add(nextFile);
                        break;
                    }
                }
            }
        }
        return filtered;
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
