package ru.nsu.odnostorontseva.task1;

import static java.lang.Math.*;

import org.jetbrains.annotations.NotNull;

/**
 * Class to check if array has a not prime number in using Multithreading.
 */
public class Threaded {

    private final int numOfThreads;
    private boolean hasNotPrime;

    /**
     * Constructor.
     *
     * @param numOfThreads - number of threads.
     */
    public Threaded(int numOfThreads) {
        this.numOfThreads = numOfThreads;
    }

    /**
     * Method for checking all numbers in an array using threads.
     *
     * @param nums - array of numbers.
     * @return - whether the array has prime numbers or not.
     */
    public boolean containsNotPrime(int @NotNull [] nums) {
        Thread[] threads = new Thread[numOfThreads];
        int chunks = (int) ceil((double) nums.length / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            final int startOfPart = i * chunks;
            final int endOfPart = min(startOfPart + chunks, nums.length);
            if (startOfPart >= nums.length) break;

            threads[i] = new Thread(() -> {
                int cnt = 0;
                for (int j = startOfPart; j < endOfPart; j++) {
                    if (!isPrime(nums[j])) {
                        cnt++;
                    }
                }
                if (cnt > 0) hasNotPrime = true;
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            if (t != null) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return hasNotPrime;
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
