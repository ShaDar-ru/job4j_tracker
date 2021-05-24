package ru.job4j.calc;

public enum RomanNumbers {
    I("I", 1), II("II", 2), III("III", 3),
    IV("IV", 4), V("V", 5), VI("VI", 6),
    VII("VII", 7), VIII("VIII", 8), IX("IX", 9);

    private int value;
    private String key;

    RomanNumbers(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public int getArabic(String s) {
        char[] chars = s.toCharArray();
        int rsl = 0;
        int a = 0;
        int y = 0;
        for (char c : chars) {
            switch (c) {
                case 'I':
                    a = 1;
                    break;
                case 'V':
                    a = 5;
                    break;
                case 'X':
                    a = 10;
                    break;
                case 'L':
                    a = 50;
                    break;
                case 'C':
                    a = 100;
                    break;
                case 'D':
                    a = 500;
                    break;
                case 'M':
                    a = 1000;
                    break;
                default:
                    break;
            }

            if (a > y) {
                a = a - y;
                rsl = rsl - y;
            }
            y = a;
            rsl = rsl + a;
        }
        return rsl;
    }
}
