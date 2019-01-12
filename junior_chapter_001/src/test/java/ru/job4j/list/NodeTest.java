package ru.job4j.list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class NodeTest {

    @Test
    public void whenHasCycleThenTrue() {
        Node<Integer> first = new Node(1);
        Node<Integer> two = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> four = new Node(4);
        Node<Integer> five = new Node(5);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;
        assertThat(Node.hasCycle(first), is(true));
    }

    @Test
    public void whenHasNotCycleThenFalse() {
        Node<Integer> first = new Node(1);
        Node<Integer> two = new Node(2);
        Node<Integer> third = new Node(3);
        Node<Integer> four = new Node(4);
        Node<Integer> five = new Node(5);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        assertThat(Node.hasCycle(first), is(false));
    }
}
