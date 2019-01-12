package ru.job4j.list;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        boolean result = false;
        Node x = first;
        Node y = first;
        while (!result) {
            x = x.next;
            y = y.next;
            if (y == null) {
                break;
            }
            y = y.next;
            if (x.next == y.next) {
                result = true;
            }
        }
        return result;
    }
}

