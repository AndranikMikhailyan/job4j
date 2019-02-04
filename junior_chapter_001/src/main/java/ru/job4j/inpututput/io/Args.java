package ru.job4j.inpututput.io;

import java.io.IOException;
import java.util.ArrayList;

public class Args {

    private String dir = null;
    private String zipName = null;
    private ArrayList<String> exts = new ArrayList<>();

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                dir = args[++i];
            } else if (args[i].equals("-o")) {
                zipName = args[++i] + ".zip";
            } else if (args[i].equals("-e")) {
                exts.add(args[++i]);
            }
        }
    }

    public String getDir() throws IOException {
        if (dir == null) {
            throw new IOException("Вы не ввели директорию");
        }
        return dir;
    }

    public String getZipName() throws IOException {
        if (zipName == null) {
            throw new IOException("Вы не ввели имя для архива");
        }
        return zipName;
    }

    public ArrayList<String> getExts() {
        return exts;
    }
}
