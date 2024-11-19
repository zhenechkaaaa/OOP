package ru.nsu.odnostorontseva.substringfinder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
    void findTest() throws IOException {
         ArrayList<Integer> res = substringSearch.find("txt", "hello");
         assertEquals(1, res.size());
    }

    @Test
    void findNoFileTest() throws IOException {
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
        String txt = "pupa is fan of Lightning McQueen";
        //int cnt = 67108864; - эта штука для 2гб, долго генерит покажу лично
        int cnt = 38; // чтобы тест работал(38-мой регион)

        File file = new File("pupaFile.txt");
        if (file.createNewFile()) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                for(int i = 0; i < cnt; i++) {
                    fos.write(txt.getBytes());
                }
                fos.close();
            } catch (IOException e) {
                throw new FileNotFoundException();
            }
        }

        ArrayList<Integer> res = substringSearch.find(file.getName(), "pupa");
        file.deleteOnExit();
        assertEquals(cnt, res.size());
    }
}