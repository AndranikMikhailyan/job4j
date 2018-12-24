package ru.job4j.lyambda;

import java.util.List;
import java.util.function.Function;

public interface Diapasone {

    List<Double> diapason(int start, int end, Function<Double, Double> func);

}
