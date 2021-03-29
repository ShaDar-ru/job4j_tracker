package ru.job4j.oop;

public class Battery {
    private int load;

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public void exchange(Battery battery) {
        battery.load = battery.load + this.load;
        this.load = 0;
    }
}
