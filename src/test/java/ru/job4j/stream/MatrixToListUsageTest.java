package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 21.04.2021
 */
public class MatrixToListUsageTest {
    @Test
    public void whenArrayInArray() {
        Integer[][] input = new Integer[][]{
                {1, 2},
                {3, 4}
        };
        MatrixToListUsage mtl = new MatrixToListUsage();
        List<Integer> result = mtl.convert(input);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDoubleArrayinArray() {
        Integer[][] input = new Integer[][]{
                {1, 2},
                {1, 2}
        };
        MatrixToListUsage mtl = new MatrixToListUsage();
        List<Integer> result = mtl.convert(input);
        List<Integer> expected = List.of(1, 2, 1, 2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNotQuadArray() {
        Integer[][] input = new Integer[][]{
                {1, 2},
                {1}
        };
        MatrixToListUsage mtl = new MatrixToListUsage();
        List<Integer> result = mtl.convert(input);
        List<Integer> expected = List.of(1, 2, 1);
        assertThat(result, is(expected));
    }
}