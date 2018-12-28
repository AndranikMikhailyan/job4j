package ru.job4j.tracker;

public class TrackerSingleInnerClass {

    private TrackerSingleInnerClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}
