package ru.job4j.inpututput.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {

    public void toZip(String dir) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(dir + ".zip"));
        File file = new File(dir);
        String prefix = file.getParent();
        if (file.isFile()) {
            String fileName = file.getPath().substring(prefix.length() + 1);
            archive(file, zipOut, fileName);
        } else if (isEmptyDirectory(file)) {
            zipOut.putNextEntry(new ZipEntry(file.getName() + "/"));
            zipOut.closeEntry();
        } else {
            toArchiveTheFile(file, zipOut, prefix);
        }
        zipOut.close();
    }

    private void toArchiveTheFile(File src, ZipOutputStream zipOut, String prefix) throws IOException {
        String pref = prefix;
        for (File file : src.listFiles()) {
            String entryName = file.getPath().substring(pref.length() + 1);
            if (file.isDirectory()) {
                if (isEmptyDirectory(file)) {
                    zipOut.putNextEntry(new ZipEntry(entryName + "/"));
                    zipOut.closeEntry();
                } else {
                    toArchiveTheFile(file, zipOut, pref);
                }
            } else {
                archive(file, zipOut, entryName);
            }
        }

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
