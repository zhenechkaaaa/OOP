package ru.nsu.odnostorontseva.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleTest {
    Sequential seqCheck;
    Threaded thrCheckFour;
    Threaded thrCheckEight;
    ParallelStream parallCheck;


    @BeforeEach
    void setup() {
         seqCheck = new Sequential();
         thrCheckFour = new Threaded(4);
         thrCheckEight = new Threaded(8);
         parallCheck = new ParallelStream();
    }

    @Test
    void allPrimeSeqTest() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        long start = System.nanoTime();
        assertFalse(seqCheck.containsNotPrime(primes));
        long end = System.nanoTime();
        System.out.println("Execution time (Sequential): " + (end - start) + " ns");
    }

    @Test
    void allPrimesThrFourTest() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        long start = System.nanoTime();
        assertFalse(thrCheckFour.containsNotPrime(primes));
        long end = System.nanoTime();
        System.out.println("Execution time (Threaded 4): " + (end - start) + " ns");
    }

    @Test
    void allPrimesThrEightTest() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        long start = System.nanoTime();
        assertFalse(thrCheckEight.containsNotPrime(primes));
        long end = System.nanoTime();
        System.out.println("Execution time (Threaded 8): " + (end - start) + " ns");
    }

    @Test
    void allPrimesParallStTest() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        long start = System.nanoTime();
        assertFalse(parallCheck.containsNotPrime(primes));
        long end = System.nanoTime();
        System.out.println("Execution time (Parallel S): " + (end - start) + " ns");
    }

}