package ru.job4j.list;

public class SimpleStack<T> {

    private SimpleLinkedList<T> stack = new SimpleLinkedList<>();

    public T poll() {
       return stack.remove();
    }

    public void push(T value) {
        stack.add(value);
    }

    public int getSize() {
        return stack.getSize();
    }
}
