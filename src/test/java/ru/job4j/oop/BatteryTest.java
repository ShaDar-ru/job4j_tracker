package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BatteryTest {

    @Test
    public void when10and5then0and15() {
        Battery battery1 = new Battery();
        Battery battery2 = new Battery();
        battery1.load = 10;
        battery2.load = 5;
        battery1.exchange(battery2);
        int expBat1Load = 0;
        int expBat2Load = 15;
        int rslBat1 = battery1.load;
        int rslBat2 = battery2.load;
        assertThat(rslBat1, is(expBat1Load));
        assertThat(rslBat2, is(expBat2Load));
    }
}