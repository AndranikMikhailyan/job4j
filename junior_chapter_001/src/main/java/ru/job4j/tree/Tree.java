package ru.job4j.tree;

import javax.imageio.ImageTranscoder;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    List<Node> children = new ArrayList<>();

    private int modCount = 0;

    public Tree(E e) {
        this.root = new Node<>(e);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rslt = false;
        Optional<Node<E>> o = findBy(parent);
        if (o.isPresent() && !o.get().leaves().contains(child)) {
            Node<E> childNode = new Node<E>(child);
            o.get().add(childNode);
            childNode.setParent(o.get());
            modCount++;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
}


    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>();
    }

    private class TreeIterator<E extends Comparable<E>> implements Iterator<E> {

        private Queue<Node<E>> data = new LinkedList<>();
        private int expectedModCount;

        public TreeIterator() {
            this.data.offer((Node<E>) root);
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return data.size() > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            data.addAll(data.peek().leaves());
            return data.poll().getValue();
        }
    }
}
