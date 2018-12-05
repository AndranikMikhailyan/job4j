package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException{
        boolean rst = false;
        try {
            int index = this.findBy(source);
            Cell[] steps = this.figures[index].way(source, dest);
            this.wayNoValidate(source, steps);
            this.figures[index] = this.figures[index].copy(dest);
            rst = true;
        } catch (FigureNotFoundException msg) {
            System.out.println(msg);
        } catch (ImpossibleMoveException msg) {
            System.out.println(msg);
        } catch (OccupiedWayException msg) {
            System.out.println(msg);
        }
        return rst;
    }

    private void wayNoValidate(Cell sours, Cell[] steps) {
        if (this.findBy(sours) == -1) {
            throw new FigureNotFoundException("Вы нажали на пустую ячейку");
        }
        for (int i = 0; i < steps.length; i++) {
            if (this.findBy(steps[i]) != -1) {
                throw new OccupiedWayException("Путь загоражден");
            }
        }
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}