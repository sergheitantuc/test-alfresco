package com.alfresco;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    public void transformToString_alfresco() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(3);

        assertThat(result).isEqualTo("alfresco");
    }

    @Test
    public void transformToString_fizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformNumber(6);

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

        assertThat(result).isEqualTo("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    @Test
    public void getReport() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.getReport("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz");

        assertThat(result).isEqualTo("fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10");
    }

    @Test
    public void getFizzBuzzStringAndReport() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String result = fizzBuzz.transformRangeAndReport(1, 20);

        assertThat(result).isEqualTo(
                "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10");
    }
}
