package ru.job4j.calc.acts;

import ru.job4j.calc.Action;
import ru.job4j.calc.Number;

public class Subtraction implements Action {

    @Override
    public Number execute(Number f, Number s) {
        return new Number(f.getNumber() - s.getNumber(), f.isArabic());
    }
}
