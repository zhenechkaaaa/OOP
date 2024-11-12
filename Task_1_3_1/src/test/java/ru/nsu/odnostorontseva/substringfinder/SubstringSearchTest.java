package ru.nsu.odnostorontseva.substringfinder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SubstringSearchTest {
    static Algorithm aho;
    static SubstringSearch substringSearch;

    @BeforeAll
    static void setUp() {
        aho = new Algorithm();
        substringSearch = new SubstringSearch();
    }

    @Test
    void find() throws IOException {
         ArrayList<Integer> res = substringSearch.find("txt", "hello");

         assertEquals(1, res.size());
    }
}