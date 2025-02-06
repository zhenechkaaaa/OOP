package ru.nsu.odnostorontseva.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequentialTest {

    private final Sequential seqCheck = new Sequential();

    @Test
    void containsNotPrimeTest() {
        assertTrue(seqCheck.containsNotPrime(new int[]{5, 6, 8, 9, 23}));
    }

    @Test
    void isPrime() {
        assertTrue(seqCheck.isPrime(2));
    }
}