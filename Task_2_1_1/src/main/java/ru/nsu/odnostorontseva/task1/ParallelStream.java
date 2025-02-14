package ru.nsu.odnostorontseva.task1;

import java.util.Arrays;

/**
 * Class to check if array has a not prime number in using ParallelStream.
 */
public class ParallelStream {

    /**
     * Method for checking all numbers in an array using parallel stream.
     *
     * @param nums - array of numbers.
     * @return - whether the array has prime numbers or not.
     */
    boolean containsNotPrime(int[] nums) {
        return Arrays
                .stream(nums)
                .parallel()
                .filter(n -> !isPrime(n))
                .count() > 0;
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

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
