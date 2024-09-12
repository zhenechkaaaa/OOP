package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class HeapSortTest {

    @Test
    void mainCheck() {
        HeapSort.main(new String[] {});
        assertTrue(true);
    }

    @Test
    void emptyArrCheck() {
        int[] expected = new int[] {};
        int[] actual = HeapSort.sort(new int[] {});
        assertArrayEquals(expected, actual);
    }

    @Test
    void singleElemCheck() {
        int[] expected = new int[] {8};
        int[] actual = HeapSort.sort(new int[] {8});
        assertArrayEquals(expected, actual);
    }

    @Test
    void usualSortCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 3, 2, 1, 4});
        assertArrayEquals(expected, actual);
    }

    @Test
    void reverseSortCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 4, 3, 2, 1});
        assertArrayEquals(expected, actual);
    }

    @Test
    void negElemsSortCheck() {
        int[] expected = new int[] {-5, -4, -3, -2, -1};
        int[] actual = HeapSort.sort(new int[] {-4, -3, -2, -1, -5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void bigElemsSortCheck() {
        int[] expected = new int[] {-2147483648, 0, 2147483647};
        int[] actual = HeapSort.sort(new int[] {0, -2147483648, 2147483647});
        assertArrayEquals(expected, actual);
    }

    @Test
    void sameElemsSortCheck() {
        int[] expected = new int[] {5, 5, 5};
        int[] actual = HeapSort.sort(new int[] {5, 5, 5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortedArrCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {1, 2, 3, 4, 5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void checkLargeArray() {
        int[] expected = new int[10000000];
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            expected[i] = random.nextInt();
        }
        Arrays.sort(expected);
        int[] actual = HeapSort.sort(expected);
        assertArrayEquals(expected, actual);
    }
}