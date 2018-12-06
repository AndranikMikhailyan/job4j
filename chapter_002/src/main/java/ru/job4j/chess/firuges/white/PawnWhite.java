package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;
    private int count = 0;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (source.y == 1) {
            if (!(source.y == dest.y - 1 || source.y == dest.y - 2 && source.x == dest.x)) {
                throw new ImpossibleMoveException("Недопустимая траектория движения");
            }
        } else if (!(source.y == dest.y - 1  && source.x == dest.x)) {
            throw new ImpossibleMoveException("Недопустимая траектория движения");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
