package ru.job4j.calc;

public class ValidateNum {
    private Number number;

    ValidateNum(String number) throws InputErrorException {
        int rsl = 0;
        boolean isArabic = true;
        try {
            rsl = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            rsl = -1;
            isArabic = false;
        }
        if (rsl == -1) {
            try {
                rsl = RomanNumbers.valueOf(number).getValue();
            } catch (IllegalArgumentException e) {
                throw new InputErrorException();
            }
        }
        if (rsl < 1 || rsl > 9) {
            throw new InputErrorException();
        }
        this.number = new Number(rsl, isArabic);
    }

    public Number getNumber() {
        return number;
    }
}
