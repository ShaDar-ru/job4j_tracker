package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void get() {
        Citizen citizen = new Citizen("1212a0", "Oleg Mihailov");
        Citizen[] citizens = new Citizen[]{
                new Citizen("1212aa", "Vasya Vasiliev"),
                new Citizen("1212a1", "Misha Vasiliev"),
                new Citizen("1212a2", "Tolya Vasiliev"),
                new Citizen("1212a3", "Sasha Vasiliev"),
                new Citizen("1212a4", "Dima Vasiliev"),
                citizen
        };
        PassportOffice office = new PassportOffice();
        for(Citizen cz : citizens){
            office.add(cz);
        }
        assertThat(office.get("1212a0"),is(citizen));
    }
}
