package com.alfresco;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void transformToString_fizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(3);

        assertThat(result).isEqualTo("fizz");
    }

    @Test
    public void transformToString_buzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(5);

        assertThat(result).isEqualTo("buzz");
    }

    @Test
    public void transformToString_fizzbuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(15);

        assertThat(result).isEqualTo("fizzbuzz");
    }

    @Test
    public void transformToString_number() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(7);

        assertThat(result).isEqualTo("7");
    }

    @Test
    public void getFizzBuzzString() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformRange(1, 20);

        assertThat(result).isEqualTo("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz");
    }
}
