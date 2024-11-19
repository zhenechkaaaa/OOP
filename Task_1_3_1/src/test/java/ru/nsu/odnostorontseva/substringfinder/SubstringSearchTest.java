package ru.nsu.odnostorontseva.substringfinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubstringSearchTest {
    static Algorithm aho;
    static SubstringSearch substringSearch;

    @BeforeEach
    void setUp() {
        aho = new Algorithm();
        substringSearch = new SubstringSearch();
    }

    @Test
    void findTest() throws IOException {
        ArrayList<Integer> res = substringSearch.find("test", "hello");
        assertEquals(1, res.size());
    }

    @Test
    void findNoFileTest() {
        assertThrows(FileNotFoundException.class,
                () -> substringSearch.find("text", "hello"));
    }

    @Test
    void findWarAndPeaceRussianTest() throws IOException {
        ArrayList<Integer> res = substringSearch.find("wap_ru.txt", "Кутузов");
        assertEquals(113, res.size());
    }

    @Test
    void findWarAndPeaceChineseTest() throws IOException {
        ArrayList<Integer> res = substringSearch.find("wap_ch.txt", "庫圖佐夫");
        assertEquals(115, res.size());
    }

    @Test
    void findWarAndPeaceEnglishTest() throws IOException {
        ArrayList<Integer> res = substringSearch.find("wap_en.txt", "Kutuzov");
        assertEquals(115, res.size());
    }

    @Test
    void genBigTextTest() throws IOException {
        String txt = "biba is fan of Lightning McQueen";
        int cnt = 67108860;

        File file = new File("pupaFile");
        if (file.createNewFile()) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                for (int i = 0; i < cnt / 2; i++) {
                    fos.write(txt.getBytes());
                }
                fos.write("pupa".getBytes());
                for (int i = 0; i < cnt / 2; i++) {
                    fos.write(txt.getBytes());
                }
                fos.close();
            } catch (IOException e) {
                throw new FileNotFoundException();
            }
        }

        ArrayList<Integer> res = substringSearch.find(file.getName(), "pupa");
        file.deleteOnExit();
        assertEquals(1, res.size());
    }
}