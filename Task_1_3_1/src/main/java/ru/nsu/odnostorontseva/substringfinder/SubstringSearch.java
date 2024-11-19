package ru.nsu.odnostorontseva.substringfinder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 */
public class SubstringSearch {
    int buffSize = 1024;
    Algorithm ahoCorasick = new Algorithm();

    /**
     * @param file ().
     * @param pattern ().
     * @return ().
     * @throws FileNotFoundException ().
     * @throws IOException ().
     */
    public ArrayList<Integer> find(String file, String pattern)
            throws FileNotFoundException, IOException {
        ahoCorasick.addPattern(pattern);

        InputStream inputStream;
        inputStream = SubstringSearch.class.getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            inputStream = new FileInputStream(file);
        }

        ArrayList<Integer> res = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] buffer = new char[buffSize];
            int readChars;
            StringBuilder currentBuffer = new StringBuilder();

            while ((readChars = reader.read(buffer)) != -1) {
                currentBuffer.append(buffer, 0, readChars);
                res.addAll(ahoCorasick.search(currentBuffer.toString(),
                        currentBuffer.length() - readChars));
                currentBuffer.setLength(0);
            }
        }
        return res;
    }
}
