package ru.nsu.odnostorontseva.substringfinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SubstringSearch {
    public ArrayList<Integer> find(String file, String pattern) throws FileNotFoundException {
        InputStream inputStream;
        inputStream = SubstringSearch.class.getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + file);
        }

        return null;
    }
}
