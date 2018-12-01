package ru.job4j.chess.firuges.black;

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

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int deltaX = Math.abs(source.x - dest.x);
        int deltaY = Math.abs(source.y - dest.y);
        boolean isDiagonal = (deltaX - deltaY == 0);
        if (isDiagonal) {
            steps = new Cell[deltaX];
            for (int i = 0; i < steps.length; i++) {
                if (dest.x > source.x) {
                    if (dest.y > source.y) {
                        for (Cell cell : Cell.values()) {
                            if ((cell.x == source.x + i + 1) && (cell.y == source.y + i + 1)) {
                                steps[i] = cell;
                                break;
                            }
                        }
                    } else {
                        for (Cell cell : Cell.values()) {
                            if ((cell.x == source.x + i + 1) && (cell.y == source.y - i - 1)) {
                                steps[i] = cell;
                                break;
                            }
                        }
                    }
                } else {
                    if (dest.y > source.y) {
                        for (Cell cell : Cell.values()) {
                            if ((cell.x == source.x - i - 1) && (cell.y == source.y + i + 1)) {
                                steps[i] = cell;
                                break;
                            }
                        }
                    } else {
                        for (Cell cell : Cell.values()) {
                            if ((cell.x == source.x - i - 1) && (cell.y == source.y - i - 1)) {
                                steps[i] = cell;
                                break;
                            }
                        }
                    }
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
