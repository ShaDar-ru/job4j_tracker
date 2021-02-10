package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;
    private int engineCount;

    public Airbus(String name) {
        this.name = name;
        getEngineCount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngineCount(int count) {
        this.engineCount = count;
    }

    private void getEngineCount() {
        switch (this.name) {
            case "A380":
                engineCount = 4;
                break;
            default:
                engineCount = COUNT_ENGINE;
                break;
        }
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println("Количество двигателей равно: " + engineCount);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}