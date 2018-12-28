package ru.job4j.tracker;

public class TrackerSingleLazy {

    private static Tracker instance;

    private TrackerSingleLazy() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
