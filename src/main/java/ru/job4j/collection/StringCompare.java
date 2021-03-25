package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        char[] left = o1.toCharArray();
        char[] right = o2.toCharArray();
        int rsl = 0;
        int length = left.length >= right.length ? left.length : right.length;
        for (int i = 0; i < length; i++) {
            if (i >= left.length) {
                rsl = -1;
                break;
            }
            if (i >= right.length) {
                rsl = 1;
                break;
            }
            if (left[i] != right[i]) {
                rsl = Character.compare(left[i], right[i]);
                break;
            }
        }
        return rsl;
    }
}
