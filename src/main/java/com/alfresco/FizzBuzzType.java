package com.alfresco;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public enum FizzBuzzType {
    FIZZ("fizz"),
    BUZZ("buzz"),
    FIZZ_BUZZ("fizzbuzz"),
    ALFRESCO("alfresco"),
    INTEGER("integer");

    private String value;

    private static Map<String, FizzBuzzType> values;

    static {
        values = new HashMap<>();

        for (FizzBuzzType value : FizzBuzzType.values()) {
            values.put(value.getValue(), value);
        }
    }

    FizzBuzzType(String value) {
        this.value = value;
    }

    public static Optional<FizzBuzzType> getInstance(final String value) {
        return ofNullable(values.get(value));
    }

    public String getValue() {
        return value;
    }
}
