package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 08.04.2021
 */
public class TestFunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup1 = () -> "New String For Interface";
        System.out.println(sup1.get());

        Supplier<Integer> sup2 = () -> 12;
        System.out.println(sup2.get());

        Supplier<Double> sup3 = () -> 12.22;
        System.out.println(sup3.get());

        TestFuncInter tfi = (x, y) -> x + y;
        System.out.println(tfi.append(1, 2));
        tfi = (x, y) -> x * y;
        System.out.println(tfi.append(1, 2));

        BiFunction<String, Integer, Integer> biFunct = (a, b) -> Integer.valueOf(
                (a + b).toString());

        /**
         * Supplier<T>{ T get()} Упрощенная форма создания объекта. Метод возвращает этот объект.
         */
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        Set<String> strings = sup.get();
        for (String s : strings) {
            System.out.println(s);
        }

        /**
         * Consumer<T> { void accept(T t) }
         * Используется если нужно применить какое-то действие или операцию к объекту
         */
        Supplier<String> supString = () -> "New String For Interface";
        Consumer<String> consString = (s) -> System.out.println(s);
        consString.accept(supString.get());

        /**
         * BiConsumer<T, U>
         *  Идентичен Консумер-у, принимает 2 параметра
         */
        BiConsumer<Set<String>, String> biConStr = (set, s) -> {
            for (String str : set) {
                if (str.equals(s)) {
                    System.out.println("Бинго!");
                }
            }
        };
        biConStr.accept(strings, "two");

        BiConsumer<String, String> biConsString = (s1, s2) -> System.out.println(s1 + s2);
        biConsString.accept(supString.get(), " and this is \"Хо-ро-шо\"");

        BiConsumer<Integer, String> biConsIntStr = (i, s) -> System.out.println(i + s);
        int i = 1;
        for (String s : strings) {
            biConsIntStr.accept(i++, " is " + s);
        }
        Predicate<String> prStr = (s) -> s.equals("one");
        BiConsumer<Set<String>, Boolean> biCnStrBool = (set, b) -> {
            for (String str : set) {
                if (b == prStr.test(str)) {
                    System.out.println(str);
                    System.out.println("Бинго!");
                }
            }
        };
        biCnStrBool.accept(strings, true);

        Function<String, Character> funcStrChar = (s) -> s.charAt(2);
        BiConsumer<Set<String>, String> biConsStrStr = (set, s2) -> {
            for (String str : set) {
                System.out.println(s2 + funcStrChar.apply(str));
            }
        };
        biConsStrStr.accept(strings, "Внутри: ");

        BiFunction<String, String, Integer> biFStrStrInt = (s1, s2) -> s1.length() + s2.length();
        int rsl = biFStrStrInt.apply("И только", "Имя твоё");
        System.out.println(rsl);

        UnaryOperator<StringBuilder> unaryStr = s -> s.reverse();
        System.out.println("Это тест: " + new StringBuilder("раздватри"));
        System.out.println("Это тест: " + unaryStr.apply(new StringBuilder("раздватри")));

        BinaryOperator<StringBuilder> binOpStbl = (s1, s2) ->
                s1.append(" ").append(s2);
        System.out.println("I " + binOpStbl.apply(
                new StringBuilder("am"), new StringBuilder("Robot")));
    }
}
