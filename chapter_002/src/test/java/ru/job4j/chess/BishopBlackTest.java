package ru.job4j.chess;

        import org.junit.Test;
        import ru.job4j.chess.firuges.Cell;
        import ru.job4j.chess.firuges.black.BishopBlack;

        import static org.junit.Assert.assertThat;
        import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenWayValid() {
        Logic logic = new Logic();
        Cell sours = Cell.F8;
        Cell dest = Cell.H6;
        BishopBlack bishopBlack = new BishopBlack(sours);
        logic.add(bishopBlack);
        logic.move(sours, dest);
        assertThat(bishopBlack.position(), is(dest));
    }
}
