package ru.job4j.calc;

public class Number {
    private int number;
    private boolean isArabic;

    public Number(int number, boolean isArabic) {
        this.number = number;
        this.isArabic = isArabic;
    }

    public int getNumber() {
        return number;
    }

    public boolean isArabic() {
        return isArabic;
    }
}
