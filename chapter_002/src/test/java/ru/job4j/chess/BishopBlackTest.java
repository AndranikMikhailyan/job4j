package ru.job4j.chess;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import ru.job4j.chess.firuges.Cell;
        import ru.job4j.chess.firuges.Figure;
        import ru.job4j.chess.firuges.black.*;
        import ru.job4j.chess.firuges.white.*;

        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;

        import static org.junit.Assert.assertThat;
        import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenWayOccupied() {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.F8);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.G7);
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        Cell sours = Cell.F8;
        Cell dest = Cell.H6;
        assertThat(logic.move(sours, dest), is(false));
    }

    @Test
    public void whenSoursIsEmpty() {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.F8);
        logic.add(bishopBlack1);
        Cell sours = Cell.E7;
        Cell dest = Cell.H6;
        assertThat(logic.move(sours, dest), is(false));
    }

    @Test
    public void whenImpossibleMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.F8);
        logic.add(bishopBlack1);
        Cell sours = Cell.F8;
        Cell dest = Cell.B5;
        assertThat(logic.move(sours, dest), is(false));
    }

    @Test
    public void whenMoveIsPossible() {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.F8);
        logic.add(bishopBlack1);
        Cell sours = Cell.F8;
        Cell dest = Cell.H6;
        assertThat(logic.move(sours, dest), is(true));
    }
}
