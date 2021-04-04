package ru.job4j.tested;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originRep = origin.toLowerCase().replaceAll("[\\p{Punct}]", "");
        String[] originArray = originRep.split("[\\p{Blank}]");
        String[] lineArray = line.toLowerCase().split("[\\p{Blank}]");
        Map<Integer, String> originMap = new HashMap<>();
        for (int i = 0; i < originArray.length; i++) {
            originMap.put(i, originArray[i]);
        }
        for (String s : lineArray) {
            if (!originMap.containsValue(s)) {
                return false;
            }
        }
        return true;
    }
}