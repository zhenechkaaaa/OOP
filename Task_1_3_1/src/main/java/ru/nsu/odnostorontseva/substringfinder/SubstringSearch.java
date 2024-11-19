package ru.nsu.odnostorontseva.substringfinder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A class for searching substrings in files using algorithm.
 */
public class SubstringSearch {
    int buffSize = 100000;
    Algorithm ahoCorasick = new Algorithm();

    /**
     * Searching pattern in the file.
     *
     * @param file    (путь к файлу(просто имя)).
     * @param pattern (подстрока).
     * @return (список индексов вхождений).
     * @throws FileNotFoundException (файл не найден).
     * @throws IOException           (ошибка ввода/вывода).
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
            int offset = 0;
            StringBuilder currentBuffer = new StringBuilder();
            StringBuilder left = new StringBuilder();

            while ((readChars = reader.read(buffer)) != -1) {
                currentBuffer.append(left);
                currentBuffer.append(buffer, 0, readChars);

                res.addAll(ahoCorasick.search(currentBuffer.toString(), offset));


                left.setLength(0);
                int leftoverLength = Math.min(currentBuffer.length(), pattern.length() - 1);
                left.append(currentBuffer, currentBuffer.length() - leftoverLength, currentBuffer.length());

                currentBuffer.setLength(0);
                offset += readChars;
            }
        }
        return res;
    }
}
