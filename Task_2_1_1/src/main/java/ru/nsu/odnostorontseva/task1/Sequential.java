package ru.nsu.odnostorontseva.task1;

import org.jetbrains.annotations.NotNull;

/**
 * Simple class to check if array has a not prime number in.
 */
public class Sequential {

    /**
     * Method for sequentially checking all numbers in an array.
     *
     * @param nums - array of numbers.
     * @return - whether the array has prime numbers or not.
     */
    public boolean containsNotPrime(int @NotNull [] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (!isPrime(num)) {
                cnt++;
            }
        }
        return cnt > 0;
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