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
}
