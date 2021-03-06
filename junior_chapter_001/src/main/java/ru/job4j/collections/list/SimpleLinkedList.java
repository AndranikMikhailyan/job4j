package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public int getSize() {
        return size;
    }

    public boolean add(E e) {
        Node<E> temp = last;
        Node<E> newLink = new Node<>(last, e);
        last = newLink;
        if (temp == null) {
            first = newLink;
        } else {
            temp.next = newLink;
        }
        size++;
        modCount++;
        return true;
    }

    public E remove() {
        Node<E> temp = last;
        last = last.prev;
        size--;
        return temp.date;
    }

    public E get(int index) {
        Node<E> x = first;
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.date;
    }

    private static class Node<E> {

        E date;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E date) {
            this.date = date;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIter();
    }

    private class ListIter implements Iterator<E> {

        private Node<E> cursor = first;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return cursor != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E e = (E) cursor;
            cursor = cursor.next;
            return e;
        }
    }
}
