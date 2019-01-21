package ru.job4j.collections.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).get().getValue(),
                is(6)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void iteratorTest() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(4, 9);
        Iterator iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(9));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenTreeBinaryThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenTreeNotBinaryThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 8);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 9);
        tree.add(3, 7);
        assertThat(tree.isBinary(), is(false));
    }
}
