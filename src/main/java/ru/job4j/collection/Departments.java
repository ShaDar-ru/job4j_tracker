package ru.job4j.collection;

import java.util.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 05.04.2021
 */
public class Departments {

    /**
     * Метод преобразует входной лист, дополняя отсутствующие
     * подразделений и сортировку
     *
     * @param deps лист входных данных департаментов
     * @return полный отсортированный список подразделений
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();

        for (String values : deps) {
            String start = "";
            for (String el : values.split("/")) {
                start = start.isEmpty() ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Сортировка в режиме NaturalOrder
     *
     * @param orgs List с входными данными
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, Comparator.naturalOrder());
    }

    /**
     * Сортировка со сложной иерархией, использует компаратор DepDescComp
     *
     * @param orgs List с входными данными
     * @see DepDescComp
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
