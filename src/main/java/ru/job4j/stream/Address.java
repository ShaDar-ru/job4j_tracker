package ru.job4j.stream;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    public int compareTo(Address address) {
        int rsl = city.compareTo(address.city);
        if (rsl == 0) {
            rsl = street.compareTo(address.street);
        }
        if (rsl == 0) {
            rsl = Integer.compare(home, address.home);
        }
        if (rsl == 0) {
            rsl = Integer.compare(apartment, address.apartment);
        }
        return rsl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return this.city.equals(address.city)
                && this.street.equals(address.street)
                && this.home == address.home
                && this.apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
