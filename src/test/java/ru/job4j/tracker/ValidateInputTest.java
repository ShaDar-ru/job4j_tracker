package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class ValidateInputTest {

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        String[] answers = new String[]{"1", "2", "3", "4"};
        Input in = new StubInput(answers);
        ValidateInput input = new ValidateInput(out, in);
        for (String s : answers) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected, is(Integer.parseInt(s)));
        }
    }

    @Test
    public void whenInputLessZero() {
        Output out = new StubOutput();
        StubInput in = new StubInput(new String[]{"-2"});
        ValidateInput inp = new ValidateInput(out, in);
        int selected = inp.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
}