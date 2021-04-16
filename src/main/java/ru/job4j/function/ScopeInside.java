package ru.job4j.function;

import java.util.function.Supplier;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 15.04.2021
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int totalFinal = total;
            total = add(
                    () -> totalFinal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}