package com.shantalia.Project2;

import java.util.Arrays;

public class RadixSort {
    void countSorting(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        //calculate the count of elements
        int[] count = new int[max + 1];
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;
        //Calculate the cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        ///place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++)
            array[i] = output[i];
        System.out.println(Arrays.toString(array));

    }

    //Function to get the largest element from an array

    int getMaximum(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
}
