package ru.job4j.poly;

public class Bus implements Transport {
    private int places;
    private double tank;
    private int price;

    @Override
    public void ride() {
        System.out.println("Wrrrrrr");
    }

    @Override
    public void passengers(int count) {
        if (count <= this.places) {
            ride();
        }
    }

    @Override
    public double fillUp(double count) {
        return price*(tank-count);
    }
}
