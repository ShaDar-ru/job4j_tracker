package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int compareTo(User o) {
        int rslStr = this.name.compareTo(o.name);
        if (rslStr == 0) {
            rslStr = Integer.compare(age, o.age);
        }
        return rslStr;
    }
}
