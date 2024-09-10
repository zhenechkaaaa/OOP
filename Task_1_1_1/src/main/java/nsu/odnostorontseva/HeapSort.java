package nsu.odnostorontseva;

import java.util.Scanner;

/**
 * Реализация пирамидальной сортировки.
 * автор: Евгения Односторонцева.
 * Класс HeapSort с методами sort и heapify.
 */
public class HeapSort {
    /**
     * Метод `sort()` реализует сортировку кучей.
     * 1. Создает кучу: Преобразует массив в кучу, где корень всегда максимальный элемент.
     * 2. Извлекает максимальный элемент.
     * 3. Обновляет кучу.
     *
     * @param arr (исходный массив)
     * @return (отсортированный массив)
     */
    public static int[] sort(int[] arr) {
        int n = arr.length;

        //построение кучи
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //вытаскиваем элементры из кучи
        for (int i = n - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            // смотрим на уменьшеную кучу
            heapify(arr, i, 0);
        }
        return arr;
    }


    /**
     * Метод `heapify` переупорядочивает элементы подкучи с корнем в позиции `i`.
     * Обеспечивает, что подкуча с корнем `i` удовлетворяет условию кучи.
     *
     * @param arr (исходный массив)
     * @param n (размер массива)
     * @param i (вершина которую сейчас проверяем)
     */
    static void heapify(int[] arr, int n, int i) {
        int root = i; // наибольший элемент - корень
        int l = 2 * i + 1; // левый
        int r = 2 * i + 2; // правый

        // левый элемент больше корня
        if (l < n && arr[l] > arr[root]) {
            root = l;
        }

        // аналогично для правого
        if (r < n && arr[r] > arr[root]) {
            root = r;
        }

        // самый большой элемент не корень
        if (root != i) {
            int tmp = arr[i];
            arr[i] = arr[root];
            arr[root] = tmp;

            // рекурсивно строим поддерево
            heapify(arr, n, root);
        }
    }

    /**
     * Впомогательная функция для вывод массива.
     *
     * @param arr (массив который нужно вывести)
     */
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Базовая функция.
     *
     * @param args (базовый параметр)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] res = sort(arr);
        printArray(res);

        scanner.close();
    }
}