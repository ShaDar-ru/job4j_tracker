package ru.job4j.oop;

public class Ball {
    public boolean run(Object obj) {
        return !(obj instanceof Fox);
    }
}
