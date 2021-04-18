package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile p = (Profile) o;
        return this.address == p.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
