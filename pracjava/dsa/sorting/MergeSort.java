package pracjava.dsa.sorting;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {

    public static void main(String args[]) {

        int[] arr = { 7, 4, 2, 7, 1, 9, 3, 5};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static int[] mergeSort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] start, int[] end) {
        int[] mix = new int[start.length + end.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                mix[k] = start[i];
                i++;
            } else {
                mix[k] = end[j];
                j++;
            }
            k++;
        }

        while (i < start.length) {
            mix[k] = start[i];
            i++;
            k++;
        }
        while (j < end.length) {
            mix[k] = end[j];
            j++;
            k++;
        }
        return mix;
    }
}