package ru.job4j.lyambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasoneRealis {

   public List<Double> diapason(int start, int end, Function<Double, Double> func) {
       List<Double> result = new ArrayList<>();
       for (int i = start; i < end + 1; i++) {
           result.add(func.apply((double) i));
       }
       return result;
   }

    public static void main(String[] args) {
        DiapasoneRealis diapasoneRealis = new DiapasoneRealis();
        List<Double> linear = diapasoneRealis.diapason(5, 10,
                aDouble -> aDouble
                );
        List<Double> squared = diapasoneRealis.diapason(5, 10,
                aDouble -> aDouble * aDouble
        );
        List<Double> logarithmic = diapasoneRealis.diapason(1, 10,
                aDouble -> Math.log(aDouble)
        );
        for (Double aDouble : logarithmic) {
            System.out.println(aDouble);
        }
    }
}
