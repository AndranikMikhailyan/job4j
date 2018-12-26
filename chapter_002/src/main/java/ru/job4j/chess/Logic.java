package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {
        boolean rst = false;
        try {
            this.soursValidate(source);
            Cell[] steps = this.figures[this.findBy(source)].way(source, dest);
            this.wayNoValidate(steps);
            this.figures[this.findBy(source)] = this.figures[this.findBy(source)].copy(dest);
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

    private boolean soursValidate(Cell sours) {
        if (this.findBy(sours) == -1) {
            throw new FigureNotFoundException("Вы нажали на пустую ячейку");
        }
        return true;
    }

    private boolean wayNoValidate(Cell[] steps) {
        for (int i = 0; i < steps.length; i++) {
            if (this.findBy(steps[i]) != -1) {
                throw new OccupiedWayException("Путь загоражден");
            }
        }
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        Optional<Figure> rst = Arrays.stream(this.figures)
                .filter(figure -> (figure != null && figure.position().equals(cell)))
                .findFirst();
        return rst.isPresent() ? Arrays.asList(figures).indexOf(rst.get()) : -1;
    }
}