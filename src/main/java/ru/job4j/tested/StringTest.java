package ru.job4j.tested;

import java.util.*;

public class StringTest {
    static char[] getInside(char[] chars, int count) {
        int countOpen = 0;
        int countClose = 0;
        char[] rsl;
        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> close = new ArrayList<>();
        ArrayList<Character> result = new ArrayList<>();
        for (int i = count; i < chars.length; i++) {
            if (chars[i] == '[') {
                open.add(i);
                countOpen++;
            }
            if (chars[i] == ']') {
                close.add(i);
                countClose++;
            }
            if (i > count && countOpen == countClose) {
                break;
            }
        }
        if (countOpen > 0) {
            for (int j = open.get(0) + 1; j < close.get(countClose - 1); j++) {
                result.add(chars[j]);
            }
            rsl = new char[result.size()];
            for (int k = 0; k < result.size(); k++) {
                rsl[k] = result.get(k);
            }
            return rsl;
        } else {
            return chars;
        }

    }

    static char[] getChars(char[] chars) {
        ArrayList<Character> characters = new ArrayList<>();
        int count;
        char[] temp;
        char[] rsl;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                if (chars[i] != '[' && chars[i] != ']') {
                    characters.add(chars[i]);
                }
            } else {
                count = Character.getNumericValue(chars[i]);
                temp = getInside(chars, i + 1);
                for (int j = 0; j < count - 1; j++) {
                    for (char a : temp) {
                        characters.add(a);
                    }
                }
            }
        }
        rsl = new char[characters.size()];
        for (int k = 0; k < characters.size(); k++) {
            rsl[k] = characters.get(k);
        }
        for (int m = 0; m < rsl.length; m++) {
            if (Character.isDigit(rsl[m])) {
                rsl = getChars(rsl);
            }
        }
        return rsl;
    }

    Comparator<String> cmpText = (left, right) -> left.compareTo(right);

    Comparator<String> cmpDescSize = (left, right) -> Integer.compare(left.length(), right.length());

    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        String a = "Аа";
        String b = "aaa";
        List<String> s = new ArrayList<>();
        s.add(a);
        s.add(b);
        Collections.sort(s,cmpDescSize);
        for(String s1 : s){
            System.out.println(s1);
        }
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Collections.sort(s,cmpText);
        System.out.println(s);
    }
}
