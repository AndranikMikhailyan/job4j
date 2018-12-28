package ru.job4j.tracker;

public class TrackerSingleEager {

    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}
