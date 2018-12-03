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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
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
        Cell[] steps = new Cell[0];
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Недопустимая траектория движения");
        }
        int deltaX = (dest.x - source.x) / Math.abs(dest.x - source.x);
        int deltaY = (dest.y - source.y) / Math.abs(dest.y - source.y);
        steps = new Cell[Math.abs(source.x - dest.x)];
        for (int i = 0; i < steps.length; i++) {
            for (Cell cell : Cell.values()) {
                if ((cell.x == source.x + deltaX + (deltaX * i)) && (cell.y == source.y + deltaY + (deltaY * i))) {
                    steps[i] = cell;
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
