package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    private boolean isVertical(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == 0 && Math.abs(source.y - dest.y) > 0;
    }

    private boolean isHorizontal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) > 0 && Math.abs(source.y - dest.y) == 0;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isHorizontal(source, dest) && !isVertical(source, dest)) {
            throw new ImpossibleMoveException("Недопустимая траектория движения");
        }
        Cell[] steps = new Cell[0];
        if (isVertical(source, dest)) {
            int deltaY = (dest.y - source.y) / Math.abs(dest.y - source.y);
            steps = new Cell[Math.abs(source.y - dest.y)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.values()[(source.x * 8 + source.y) + (deltaY + (deltaY * i))];
            }
        } else if (isHorizontal(source, dest)) {
            int deltaX = (dest.x - source.x) / Math.abs(dest.x - source.x);
            steps = new Cell[Math.abs(source.x - dest.x)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.values()[(source.x * 8 + source.y) + ((deltaX + (deltaX * i)) * 8)];
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
