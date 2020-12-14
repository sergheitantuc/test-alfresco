package com.alfresco.service;

import com.alfresco.api.v1.dto.FizzBuzzDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

public class FizzBuzzServiceTest {

    @Test
    public void transformToString_alfresco() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformNumber(3);

        assertThat(result).isEqualTo("alfresco");
    }

    @Test
    public void transformToString_fizz() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformNumber(6);

        assertThat(result).isEqualTo("fizz");
    }

    @Test
    public void transformToString_buzz() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformNumber(5);

        assertThat(result).isEqualTo("buzz");
    }

    @Test
    public void transformToString_fizzbuzz() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformNumber(15);

        assertThat(result).isEqualTo("fizzbuzz");
    }

    @Test
    public void transformToString_number() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformNumber(7);

        assertThat(result).isEqualTo("7");
    }

    @Test
    public void getFizzBuzzString() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.transformRange(1, 20);

        assertThat(result).isEqualTo("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    @Test
    public void getReport() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        String result = fizzBuzzService.getReport("1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz");

        assertThat(result).isEqualTo("fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10");
    }

    @Test
    public void getFizzBuzzStringAndReport() {
        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        FizzBuzzDto result = fizzBuzzService.transformRangeAndReport(1, 20);

        final String expectedValue = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";
        final String expectedReport = "fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10";

        assertThat(result)
                .returns(expectedValue, from(FizzBuzzDto::getValue))
                .returns(expectedReport, from(FizzBuzzDto::getReport));
    }
}
