package ru.job4j.poly;

public class Plane implements Vehicle {
    final private String name = "Самолет";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("На взлет!");
    }
}
