package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> inputStack = new SimpleStack<>();
    private SimpleStack<T> outputStack = new SimpleStack<>();

    public void push(T value) {
        inputStack.push(value);
    }

    public T poll() {
        if (outputStack.getSize() == 0) {
            while (inputStack.getSize() > 0) {
                outputStack.push(inputStack.poll());
            }
        }
        return outputStack.poll();
    }
}
