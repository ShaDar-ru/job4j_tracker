package ru.job4j.poly;

public class Bus implements Vehicle {
    final private String name = "Автобус";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Пристегните ремни, автобус отправляется");
    }
}
