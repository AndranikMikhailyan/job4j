package ru.job4j.tracker;

public enum TrackerSingleEnam {
    INSTANCE(new Tracker());

    private final Tracker instance;

    TrackerSingleEnam(Tracker instance) {
        this.instance = instance;
    }
}
