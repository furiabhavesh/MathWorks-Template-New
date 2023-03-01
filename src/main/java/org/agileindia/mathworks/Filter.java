package org.agileindia.mathworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static final Predicate<Integer> EVEN = Filter::isEven;
    public static final Predicate<Integer> PERFECT = Filter::isPerfect;

    private static boolean isPerfect(int number) {
        if (number > 0) {
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    factors.add(i);
                }
            }
            // Sum of factors
            int sumOfFactors = 0;
            for (Integer i : factors) {
                sumOfFactors += i;
            }
            // It is a perfect number if the difference between sum of factors and the
            // number is equal to the number itself
            return sumOfFactors - number == number;
        }
        return false;
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static List<Integer> select(List<Integer> numbers, Predicate<Integer> ... predicates) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if(predicates[0].test(number)){
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }
}