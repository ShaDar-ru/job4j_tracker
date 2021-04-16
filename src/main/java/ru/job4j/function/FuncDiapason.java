package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 16.04.2021
 */
public class FuncDiapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double d = (double) i;
            rsl.add(func.apply(d));
        }
        return rsl;
    }
}
