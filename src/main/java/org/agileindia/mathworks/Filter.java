package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static final Predicate<Integer> EVEN = Filter::isEven;
    public static final Predicate<Integer> PERFECT = Filter::isPerfect;

    @SafeVarargs
    public static List<Integer> select(final List<Integer> numbers, Predicate<Integer> ... predicates) {
        List<Integer> filteredNumbers = numbers;
        List<Integer> temp;
        for (Predicate<Integer> predicate: predicates){
            temp = new ArrayList<>();
            for (Integer number : filteredNumbers) {
                if (predicate.test(number)) {
                    temp.add(number);
                }
            }
            filteredNumbers = temp;
        }
        return filteredNumbers;
    }

    private static boolean isPerfect(int number) {
        if (number <= 0)
            return false;

        return sum(factors(number)) - number == number;
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> factors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 1; divisor <= number; divisor++) {
            if (number % divisor == 0) {
                factors.add(divisor);
            }
        }
        return factors;
    }
}