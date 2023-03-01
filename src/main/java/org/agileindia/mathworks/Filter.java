package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static final Predicate<Integer> EVEN = Filter::isEven;
    public static final Predicate<Integer> PERFECT = Filter::isPerfect;

    private static boolean isPerfect(int number) {
        if (number > 0) {
            List<Integer> factors = factors(number);
            // Sum of factors
            int sumOfFactors = sum(factors);
            // It is a perfect number if the difference between sum of factors and the
            // number is equal to the number itself
            return sumOfFactors - number == number;
        }
        return false;
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
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

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
}