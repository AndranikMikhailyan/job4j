package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> {

    private Node<K, V>[] table;

    private int modCount = 0;

    private final int minCapacity = 16;

    public SimpleHashMap() {
        table = new Node[minCapacity];
    }

    public SimpleHashMap(int size) {
        table = new Node[size < minCapacity ? minCapacity : size];
    }

    private final int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode() % (table.length - 1));
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        if (loadFaktor() > 0.7) {
            table = grow(table);
        }
        Node<K, V> p = new Node<>(key, value, hash(key));
        if (table[p.hash] == null) {
            table[p.hash] = p;
            modCount++;
            result = true;
        }
        return result;
    }

    private Node<K, V>[] grow(Node<K, V>[] oldTable) {
        Node<K, V>[] newTable = new Node[newTableSize()];
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                newTable[node.hash] = node;
            }
        }
        return newTable;
    }

    private int newTableSize() {
        return table.length + (table.length >> 1) + 1;
    }

    private double loadFaktor() {
        return (double) modCount / table.length;
    }

    public V get(K key) {
        if (table[hash(key)] == null) {
            throw new NoSuchElementException();
        }
        return table[hash(key)].value;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (table[hash(key)] != null) {
            table[hash(key)] = null;
            modCount--;
            result = true;
        }
        return result;
    }

    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    public Iterator<V> valueIterator() {
        return new ValueIterator();
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new EntryIterator();
    }

    static class Node<K, V> implements Map.Entry<K, V> {

        final K key;
        V value;
        final int hash;
//        Node<K, V> next;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    private abstract class HashIterator {
        Node<K, V> next;
        int expectedModCount;
        int index;

        public HashIterator() {
            Node<K, V>[] t = table;
            expectedModCount = modCount;
            index = 0;
            next = null;
            do {
                next = t[index++];
            } while (index < t.length && next == null);
        }

        public final boolean hasNext() {
            return next != null;
        }

        final Node<K, V> nextNode() {
            Node<K, V>[] t = table;
            Node<K, V> result = next;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (index < t.length) {
                do {
                    next = t[index++];
                } while (index < t.length && next == null);
            }
            return result;
        }
    }

    private class KeyIterator extends HashIterator implements Iterator<K> {

        @Override
        public K next() {
            return nextNode().key;
        }
    }

    private class ValueIterator extends HashIterator implements Iterator<V> {

        @Override
        public V next() {
            return nextNode().value;
        }
    }
    private class EntryIterator extends HashIterator implements Iterator<Map.Entry<K, V>> {

        @Override
        public Map.Entry<K, V> next() {
            return nextNode();
        }
    }
}
