package com.alfresco;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.alfresco.FizzBuzzType.*;
import static java.util.stream.Collectors.*;

public class FizzBuzz {

    /**
     * Transforms a contiguous range of integers to a FizzBuzz string
     * @param startNumber the (inclusive) initial value
     * @param endNumber the inclusive upper bound
     * @return a FizzBuzz string
     */
    public String transformRangeAndReport(int startNumber, int endNumber) {
        String transformedFizzBuzz = IntStream.rangeClosed(startNumber, endNumber)
                .mapToObj(this::transformNumber)
                .collect(joining(" "));

        String reportResult = getReport(transformedFizzBuzz);

        return transformedFizzBuzz + "\n" + reportResult;
    }

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
        if (numberContainsDigit(number, 3)) {
            return ALFRESCO.getValue();
        }

        String result = "";

        result += number % 3 == 0? FIZZ.getValue() : "";
        result += number % 5 == 0? BUZZ.getValue() : "";

        return result.isEmpty()? Integer.toString(number) : result;
    }

    /**
     * Checks if the given number contains the given digit
     * @param number the number to be tested
     * @param digit element whose presence in the number is to be tested
     * @return {@code true} if the number contains the specified digit
     */
    public boolean numberContainsDigit(int number, int digit) {
        return Integer.toString(number).contains(Integer.toString(digit));
    }

    /**
     * Produces a report showing how many times the FizzBuzzType appears in the given string
     * @param fizzBuzzString a fizz buzz string
     * @return the report
     */
    public String getReport(String fizzBuzzString) {
        Map<FizzBuzzType, Long> reportData = Stream.of(fizzBuzzString.split(" "))
                .map(value -> FizzBuzzType.getInstance(value).orElse(INTEGER))
                .collect(groupingBy(stringValue -> stringValue, counting()));

        return Stream.of(FizzBuzzType.values())
                .map(type -> type.getValue() + ": " + reportData.get(type))
                .collect(joining(" "));
    }

}
