package ru.job4j.prof;

public class Builder extends Engineer {
    private int height;

    public Builder(String name,
                   String education,
                   int patents,
                   int projects,
                   int height
    ) {
        super(name, education, patents, projects);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public static void main(String[] args) {
        Builder builder = new Builder(
                "Вася",
                "Универ",
                1,
                2,
                25
        );
    }
}
