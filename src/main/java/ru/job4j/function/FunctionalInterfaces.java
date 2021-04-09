package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.04.2021
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);

        /*
            Замените вставку элементов в карту на использование BiConsumer,
            он уже объявлен, требуется его реализовать.
         */
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            /*
                Замените проверку в if() на использование BiPredicate,
                он объявлен выше, требуется его реализовать.
             */
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        /*
            Заменить создание ArrayList из значений Map на Supplier, объявлен ниже,
            требуется его реализовать.
         */
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            s = func.apply(s);
            /*
                Заменить вывод строк на применение Consumer
                Заменить преобразование строк к строкам в верхнем регистре с помощью Function
                Необходимое объявлено выше, требуется их реализовать.
            */
            con.accept(s);
        }
    }
}
