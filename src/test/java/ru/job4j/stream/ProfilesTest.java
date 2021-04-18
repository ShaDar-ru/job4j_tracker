package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenGetAddress() {
        Profiles pr = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(
                        new Address("Msc", "Moscovskaya", 12, 52)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 25)),
                new Profile(
                        new Address("VN", "BigSp-kaya", 155, 43))
        );
        List<Address> result = pr.collect(profiles);
        List<Address> expect = List.of(
                new Address("Msc", "Moscovskaya", 12, 52),
                new Address("Spb", "Mayakovskaya", 22, 25),
                new Address("VN", "BigSp-kaya", 155, 43)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetSortedAddress() {
        Profiles pr = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(
                        new Address("Msc", "Moscovskaya", 12, 52)),
                new Profile(
                        new Address("VN", "BigSp-kaya", 155, 43)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 25))
        );
        List<Address> result = pr.collect(profiles);
        List<Address> expect = List.of(
                new Address("Msc", "Moscovskaya", 12, 52),
                new Address("Spb", "Mayakovskaya", 22, 25),
                new Address("VN", "BigSp-kaya", 155, 43)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetSortedAddressAndGet2Cities() {
        Profiles pr = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(
                        new Address("Msc", "Moscovskaya", 12, 52)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 25)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 23))
        );
        List<Address> result = pr.collect(profiles);
        List<Address> expect = List.of(
                new Address("Msc", "Moscovskaya", 12, 52),
                new Address("Spb", "Mayakovskaya", 22, 25),
                new Address("Spb", "Mayakovskaya", 22, 23)
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenGetDoubledAddress() {
        Profiles pr = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(
                        new Address("Msc", "Moscovskaya", 12, 52)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 25)),
                new Profile(
                        new Address("Spb", "Mayakovskaya", 22, 25))
        );
        List<Address> result = pr.collect(profiles);
        List<Address> expect = List.of(
                new Address("Msc", "Moscovskaya", 12, 52),
                new Address("Spb", "Mayakovskaya", 22, 25)
        );
        assertThat(result, is(expect));
    }

}