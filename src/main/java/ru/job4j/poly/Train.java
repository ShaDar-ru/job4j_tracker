package ru.job4j.poly;

public class Train implements Vehicle {
    private String nextLandingSite;
    final String name = "Поезд";

    public Train(String nextLandingSite){
        this.nextLandingSite = nextLandingSite;
    }

    public void setNextLandingSite(String s){
        this.nextLandingSite=s;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        System.out.println("Внимаение! Двери закрываются, следующая станция " + this.nextLandingSite);
    }
}
