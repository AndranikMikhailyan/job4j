package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        System.out.println(rsl);
        assertThat(rsl, is(String.format("X X%s X %sX X%s", ln, ln, ln)));
    }

    @Test
    public void when5x3() {
        Board board = new Board();
        String rsl = board.paint(5, 3);
        String ln = System.lineSeparator();
        System.out.println(rsl);
        assertThat(rsl, is(String.format("X X X%s X X %sX X X%s", ln, ln, ln)));
    }
}