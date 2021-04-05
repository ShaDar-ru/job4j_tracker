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
        Set<String> tmp2 = new LinkedHashSet<>();
        for (String values : deps) {
            Collections.addAll(tmp, values.split("/"));
        }
        for (String values : deps) {
            String start = "";
            for (String s : values.split("/")) {
                for (String s2 : tmp) {
                    if (s.equals(s2)) {
                        if (start.isEmpty()) {
                            start = s2;
                        } else {
                            start = start + "/" + s2;
                        }
                        tmp2.add(start);
                    }
                }
            }
        }
        return new ArrayList<>(tmp2);
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
     * Сортировка со сложной иерархией, использует компаратор
     *
     * @param orgs List с входными данными
     * @see DepDescComp
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

    /**
     * Внутренний статический класс-компаратор. Применяется для
     * сложной проверки, в обратном порядке:
     * - Сперва сравниваются супер-подразделения, в обратном порядке;
     * - После сравниваются подразделения и под-подразделения,
     * в порядке возростания.
     */
    public static class DepDescComp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String[] o1Arr = o1.split("/");
            String[] o2Arr = o2.split("/");
            int lnth = Math.min(o1Arr.length, o2Arr.length);
            int tmp = 0;
            for (int i = 0; i < lnth; i++) {
                if (i == 0) {
                    tmp = o2Arr[i].compareTo(o1Arr[i]);
                    if (tmp != 0) {
                        break;
                    }
                }
                if (i > 0) {
                    tmp = o1Arr[i].compareTo(o2Arr[i]);
                    if (tmp != 0) {
                        break;
                    }
                }
            }
            if (tmp == 0) {
                if (o1Arr.length > o2Arr.length) {
                    tmp = 1;
                }
                if (o1Arr.length < o2Arr.length) {
                    tmp = -1;
                }
            }
            return tmp;
        }
    }
}
