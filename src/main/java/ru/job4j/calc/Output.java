package ru.job4j.calc;

public class Output {
    public void print(Number out) {
        if (!out.isArabic()) {
            System.out.println(getRomNumb(out));
        } else {
            System.out.println(out.getNumber());
        }
    }

    private String getRomNumb(Number out) {
        String rsl = null;
        for (RomanNumbers rmnb : RomanNumbers.values()) {
            if (rmnb.getValue() == out.getNumber()) {
                rsl = rmnb.getKey();
            }
        }
        return rsl;
    }
}
