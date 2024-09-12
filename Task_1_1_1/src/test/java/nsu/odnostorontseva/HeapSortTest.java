package nsu.odnostorontseva;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class HeapSortTest {

    @Test
    void MainCheck() {
        HeapSort.main(new String[] {});
        assertTrue(true);
    }

    @Test
    void EmptyArrCheck() {
        int[] expected = new int[] {};
        int[] actual = HeapSort.sort(new int[] {});
        assertArrayEquals(expected, actual);
    }

    @Test
    void SingleElemCheck() {
        int[] expected = new int[] {8};
        int[] actual = HeapSort.sort(new int[] {8});
        assertArrayEquals(expected, actual);
    }

    @Test
    void UsualSortCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 3, 2, 1, 4});
        assertArrayEquals(expected, actual);
    }

    @Test
    void ReverseSortCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 4, 3, 2, 1});
        assertArrayEquals(expected, actual);
    }

    @Test
    void NegElemsSortCheck() {
        int[] expected = new int[] {-5, -4, -3, -2, -1};
        int[] actual = HeapSort.sort(new int[] {-4, -3, -2, -1, -5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void BigElemsSortCheck() {
        int[] expected = new int[] {-2147483648, 0, 2147483647};
        int[] actual = HeapSort.sort(new int[] {0, -2147483648, 2147483647});
        assertArrayEquals(expected, actual);
    }

    @Test
    void SameElemsSortCheck() {
        int[] expected = new int[] {5, 5, 5};
        int[] actual = HeapSort.sort(new int[] {5, 5, 5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void SortedArrCheck() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {1, 2, 3, 4, 5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void CheckLargeArray() {
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