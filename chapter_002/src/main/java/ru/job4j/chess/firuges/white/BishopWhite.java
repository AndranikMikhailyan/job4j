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
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Недопустимая траектория движения");
        }
        Cell[] steps = new Cell[0];
        int deltaX = (dest.x - source.x) / Math.abs(dest.x - source.x);
        int deltaY = (dest.y - source.y) / Math.abs(dest.y - source.y);
        steps = new Cell[Math.abs(source.x - dest.x)];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.values()[(source.x * 8 + source.y) + ((deltaX + (deltaX * i)) * 8 + (deltaY + (deltaY * i)))];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
