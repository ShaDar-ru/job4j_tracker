package ru.job4j.tested;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originRep = origin.toLowerCase().replaceAll("[\\p{Punct}]", "");
        String[] originArray = originRep.split("[\\p{Blank}]");
        Set<String> originSet = new HashSet<>(Arrays.asList(originArray));
        String[] lineArray = line.toLowerCase().split("[\\p{Blank}]");
        for (String s : lineArray) {
            if (!originSet.contains(s)) {
                return false;
            }
        }
        return true;
    }
}