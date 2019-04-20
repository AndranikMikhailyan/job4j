package ru.job4j.io;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        List<File> rslt = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(parent));
        while (queue.size() > 0) {
            if (queue.peek().isDirectory()) {
                exts.stream().forEach(
                        s -> rslt.addAll(Arrays.asList(queue.peek().listFiles(new OnlyExr(s))))
                );
                Arrays.stream(queue.poll().listFiles()).forEach(
                        file -> {
                            if (file.isDirectory()) {
                                queue.add(file);
                            }
                        }
                );
            }
        }
        return rslt;
    }

    class OnlyExr implements FilenameFilter {

        String ext;

        public OnlyExr(String ext) {
            this.ext = "." + ext;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    public static class FileSearch {

        private Path dir;
        private Path file;
        private String name;
        private String mod;

        public FileSearch(String[] args) {
            this.argsParse(args);
        }

        private String help() {
            return Joiner.on(System.lineSeparator())
                    .join(
                            "Вы ввели не достаточно данных.",
                            "Аргументы должны содержать: -d c:/ -n *.txt -m -o log.txt",
                            "Ключи ",
                            "-d - директория в которая начинать поиск.",
                            "-n - имя файл, маска, либо регулярное выражение.",
                            "-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.",
                            "-o - результат записать в файл."
                    );
        }

        private String key() {
            return Joiner.on(System.lineSeparator())
                    .join(
                            "Вы ввели недопустимый ключ.",
                            "Ключи могут быть следующие:",
                            "-d - директория в которая начинать поиск.",
                            "-n - имя файл, маска, либо регулярное выражение.",
                            "-m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.",
                            "-o - результат записать в файл."
                    );
        }

        private void argsParse(String[] args) {
            if (args.length != 7) {
                throw new IllegalArgumentException(help());
            }
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-d")) {
                    dir = Paths.get(args[++i]);
                } else if (args[i].equals("-n")) {
                    name = args[++i];
                } else if (args[i].equals("-m")
                        || args[i].equals("-f")
                        || args[i].equals("-r")) {
                    mod = args[i];
                } else if (args[i].equals("-o")) {
                    file = Paths.get(args[++i]);
                } else {
                    throw new IllegalArgumentException(this.key() + args[i]);
                }
            }
        }

        private void findByName(String name) throws IOException {
            Files.walk(this.dir).forEach(
                    path -> {
                        if (path.endsWith(name)) {
                            try {
                                Files.copy(
                                        path,
                                        this.file,
                                        StandardCopyOption.REPLACE_EXISTING,
                                        StandardCopyOption.COPY_ATTRIBUTES);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            );
        }

        private void findByMask(String mask) throws IOException {
            Files.walk(this.dir).forEach(
                    path -> {
                        if (path.toString().matches(mask)) {
                            System.out.println(path);
                        }
                    }
            );

        }

        private void findByReg(String mask) {

        }

        public static void main(String[] args) throws IOException {
            String[] strings = {"-d", "D:\\Работа\\1_Цех сушки\\Цех сушки", "-n", "ЦТП Цех сушки СО.xls", "-f", "-o", "log.xls"};
            FileSearch fSearch = new FileSearch(strings);
            fSearch.findByName(fSearch.name);

        }
    }
}
