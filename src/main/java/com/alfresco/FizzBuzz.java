package com.alfresco;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class FizzBuzz {

    /**
     * Transforms a contiguous range of integers to a FizzBuzz string
     * @param startNumber the (inclusive) initial value
     * @param endNumber the inclusive upper bound
     * @return a FizzBuzz string
     */
    public String transformRange(int startNumber, int endNumber) {
        return IntStream.rangeClosed(startNumber, endNumber)
                .mapToObj(this::transformNumber)
                .collect(joining(" "));
    }

    /**
     * Transforms an integers to a FizzBuzz string
     * @param number the number to be transformed
     * @return a FizzBuzz string
     */
    public String transformNumber(int number) {
        String result = "";

        result += number % 3 == 0? "fizz" : "";
        result += number % 5 == 0? "buzz" : "";

        return result.isEmpty()? Integer.toString(number) : result;
    }

}
