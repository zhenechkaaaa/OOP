package nsu.odnostorontseva;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest{

    @Test
    void main_check() {
        HeapSort.main(new String[] {});
        assertTrue(true);
    }

    @Test
    void empty_arr_check() {
        int[] expected = new int[] {};
        int[] actual = HeapSort.sort(new int[] {});
        assertArrayEquals(expected, actual);
    }

    @Test
    void single_elem_check() {
        int[] expected = new int[] {8};
        int[] actual = HeapSort.sort(new int[] {8});
        assertArrayEquals(expected, actual);
    }

    @Test
    void usual_sort_check() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 3, 2, 1, 4});
        assertArrayEquals(expected, actual);
    }

    @Test
    void reverse_sort_check() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        int[] actual = HeapSort.sort(new int[] {5, 4, 3, 2, 1});
        assertArrayEquals(expected, actual);
    }

    @Test
    void neg_elems_sort_check() {
        int[] expected = new int[] {-5, -4, -3, -2, -1};
        int[] actual = HeapSort.sort(new int[] {-4, -3, -2, -1, -5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void big_elems_sort_check() {
        int[] expected = new int[] {-2147483648, 0, 2147483647};
        int[] actual = HeapSort.sort(new int[] {0, -2147483648, 2147483647});
        assertArrayEquals(expected, actual);
    }

    @Test
    void same_elems_sort_check() {
        int[] expected = new int[] {5, 5, 5};
        int[] actual = HeapSort.sort(new int[] {5, 5, 5});
        assertArrayEquals(expected, actual);
    }

    @Test
    void big_arr_sort_check() {
        int[] expected = new int[] {-2147483648, 0, 2147483647};
        int[] actual = HeapSort.sort(new int[] {0, -2147483648, 2147483647});
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