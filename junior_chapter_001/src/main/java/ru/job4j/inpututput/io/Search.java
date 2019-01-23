package ru.job4j.inpututput.io;

import java.io.File;
import java.io.FilenameFilter;
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
}
