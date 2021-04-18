package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }*/

    public List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comp = Comparator.comparing(Address::getCity)
                .thenComparing(Address::getStreet)
                .thenComparing(Address::getHome)
                .thenComparing(Address::getApartment);
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(comp)
                .distinct()
                .collect(Collectors.toList());
    }
}
