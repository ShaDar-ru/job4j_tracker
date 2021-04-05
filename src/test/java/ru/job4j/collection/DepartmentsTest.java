package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 05.04.2021
 */
public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenManyMissedWithNaturalOrder() {
        List<String> input = Arrays.asList("k1/sk1", "k2", "k2/sk1", "k2/sk2", "k2/sk1/ssk1/sssk1");
        List<String> expect = Arrays.asList(
                "k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk1/sssk1", "k2/sk2"
        );
        List<String> rsl = Departments.fillGaps(input);
        rsl.sort(Comparator.naturalOrder());
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenManyMissedWithDepDescComp() {
        List<String> input = Arrays.asList("k1/sk1", "k2", "k2/sk1", "k2/sk2", "k2/sk1/ssk1/sssk1");
        List<String> expect = Arrays.asList(
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk1/sssk1", "k2/sk2", "k1", "k1/sk1"
        );
        List<String> rsl = Departments.fillGaps(input);
        Departments.sortDesc(rsl);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenManyMissedAndNotValid() {
        List<String> input = Arrays.asList(
                "k1/sk1", "k2", "k1/sk2", "k2/sk1", "k2/sk2", "k2/sk1/ssk1/sssk1"
        );
        List<String> expect = Arrays.asList(
                "k1", "k1/sk1", "k1/sk2", "k2", "k2/sk1",
                "k2/sk1/ssk1", "k2/sk1/ssk1/sssk1", "k2/sk2"
        );
        List<String> rsl = Departments.fillGaps(input);
        Departments.sortAsc(rsl);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void compare() {
        int rsl = new Departments.DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new Departments.DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenVariousDepartments() {
        int rsl = new Departments.DepDescComp().compare(
                "K1",
                "K2/SK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenVariousDepartmentsAndSubDepartments() {
        int rsl = new Departments.DepDescComp().compare(
                "K1/SK2",
                "K2/SK1"
        );
        assertThat(rsl, greaterThan(0));
    }
}