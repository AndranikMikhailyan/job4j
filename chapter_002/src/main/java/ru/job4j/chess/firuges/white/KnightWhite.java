package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        boolean deltaX2 = Math.abs(dest.x - source.x) == 2 && Math.abs(dest.y - source.y) == 1;
        boolean deltaY2 = Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2;
        if (!deltaX2 && !deltaY2) {
            throw new ImpossibleMoveException("Недопустимая траектория движения");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
