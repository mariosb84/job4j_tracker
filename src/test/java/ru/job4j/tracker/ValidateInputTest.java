package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList( "3", "4")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
    }
    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList( "1", "2", "3", "4")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        int selected3 = input.askInt("Enter menu:");
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        assertThat(selected2, is(2));
        assertThat(selected3, is(3));
        assertThat(selected4, is(4));
    }
    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("-1", "-2", "-3")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}