package ru.job4j.streams;

import java.util.Objects;

public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(tuple.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
