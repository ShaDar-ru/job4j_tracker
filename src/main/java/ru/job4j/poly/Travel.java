package ru.job4j.poly;

public class Travel {

    public static void main(String[] args) {

        Vehicle bus = new Bus();
        Vehicle plane = new Plane();
        Vehicle train = new Train("Конечная");

        Vehicle[] vehicles = new Vehicle[]{bus, plane, train};
        for (Vehicle v : vehicles) {
            System.out.println(v.getName() + " перед оправкой сообщает: ");
            v.move();
        }
    }
}
