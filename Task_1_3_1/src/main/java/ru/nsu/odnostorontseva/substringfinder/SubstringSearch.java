package ru.nsu.odnostorontseva.substringfinder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubstringSearch {
    int BUFF_SIZ = 1024;
    Algorithm ahoCorasick = new Algorithm();

    public ArrayList<Integer> find(String file, String pattern) throws FileNotFoundException, IOException {
        ahoCorasick.addPattern(pattern);

        InputStream inputStream;
        inputStream = SubstringSearch.class.getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + file);
        }

        ArrayList<Integer> res = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] buffer = new char[BUFF_SIZ];
            int readChars;
            StringBuilder currentBuffer = new StringBuilder();

            while ((readChars = reader.read(buffer)) != -1) {
                currentBuffer.append(buffer, 0, readChars);

                res.addAll(ahoCorasick.search(currentBuffer.toString()));
            }
        }
        return res;
    }
}
