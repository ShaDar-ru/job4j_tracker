package ru.job4j.oop;

public class Battery {

    public int load;

    public void exchange(Battery battery) {
        battery.load = battery.load + this.load;
        this.load = 0;
    }
}
