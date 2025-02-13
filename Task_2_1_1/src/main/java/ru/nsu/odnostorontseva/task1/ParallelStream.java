package ru.nsu.odnostorontseva.task1;

import java.util.Arrays;

public class ParallelStream {

    boolean containsNotPrime(int[] numbers) {
        return Arrays.stream(numbers).parallel().anyMatch(n -> !isPrime(n));
    }

    /**
     * Method that checks whether a number is prime.
     *
     * @param num - number to check.
     * @return - is prime or not.
     */
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i*i <= num; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
