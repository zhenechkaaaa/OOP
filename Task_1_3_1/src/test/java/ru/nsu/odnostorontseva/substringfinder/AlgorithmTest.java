package ru.nsu.odnostorontseva.substringfinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class AlgorithmTest {
    Algorithm ahoCorasick;

    @BeforeEach
    void setUp() {
        this.ahoCorasick = new Algorithm();
    }

    @Test
    void search() {
        String pattern = "he";
        ahoCorasick.addPattern(pattern);
        String text = "memeemmeememeemmnennenmeee";

        List<Integer> result = ahoCorasick.search(text);

        assertEquals(0, result.size());
    }
}