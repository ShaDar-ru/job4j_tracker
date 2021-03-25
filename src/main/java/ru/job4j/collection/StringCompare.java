package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int length = Math.max(o1.length(), o2.length());
        for (int i = 0; i < length; i++) {
            if (i >= o1.length() || i >= o2.length()) {
                rsl = Integer.compare(o1.length(), o2.length());
                break;
            }
            if (o1.charAt(i) != o2.charAt(i)) {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
                break;
            }
        }
        return rsl;
    }
}
