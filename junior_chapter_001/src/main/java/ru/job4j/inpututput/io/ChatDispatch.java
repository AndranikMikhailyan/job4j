package ru.job4j.inpututput.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;

public class ChatDispatch {

    private HashMap<String, Supplier<Boolean>> actions = new HashMap<>();
    private File file;
    private RandomAccessFile ansvers;
    private Random rnd = new Random();
    private String state;

    public ChatDispatch(File file) throws FileNotFoundException {
        this.file = file;
        ansvers = new RandomAccessFile(file, "r");
        actions.put("стоп", this.stop());
        actions.put("продолжить", this.botContinue());
        actions.put("закончить", this.exit());
        this.state = "";
    }

    public boolean read(String phrase) {
        System.out.println("Я написал :" + phrase);
        if (state.equals("стоп") && !phrase.equals("продолжить") && !phrase.equals("закончить")) {
            phrase = state;
        } else if (state.equals("продолжить") && !phrase.equals("закончить") && !phrase.equals("стоп")) {
            phrase = "";
        }
        boolean result = true;
        if (this.actions.get(phrase) == null) {
            result = this.ansver().get();
        } else {
            result = actions.get(phrase).get();
        }
        return result;
    }

    private Supplier<Boolean> ansver() {
        return () -> {
            try {
                ansvers.seek(rnd.nextInt((int) ansvers.length()));
                ansvers.readLine();
                System.out.println(
                        "Бот написал: "
                                + new String(ansvers.readLine().getBytes(StandardCharsets.ISO_8859_1), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    private Supplier<Boolean> botContinue() {
        return () -> {
            state = "продолжить";
            try {
                ansvers.seek(rnd.nextInt((int) ansvers.length()));
                ansvers.readLine();
                System.out.println(
                        "Бот продолжает отвечать и написал: "
                                + new String(ansvers.readLine().getBytes(StandardCharsets.ISO_8859_1), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    private Supplier<Boolean> stop() {
        return () -> {
            state = "стоп";
            System.out.println("Бот ждет команды продолжить:");
            return true;
        };
    }

    private Supplier<Boolean> exit() {
        return () -> false;
    }
}
