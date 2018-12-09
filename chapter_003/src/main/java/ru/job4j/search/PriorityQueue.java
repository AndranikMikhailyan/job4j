package ru.job4j.search;

import java.util.LinkedList;
import java.util.Objects;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() > task.getPriority()) {
                tasks.add(i, task);
                break;
            }
        }
        if (!tasks.contains(task)) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
