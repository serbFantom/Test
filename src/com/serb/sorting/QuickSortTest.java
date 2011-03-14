package com.serb.sorting;

import java.util.Arrays;

/**
 * User: S.Bezuglyi
 * Date: Jan 25, 2011
 */
public class QuickSortTest {

    private int[] numbers;
    private int number;

    public void sort(int[] values, boolean printValues) {
        // Check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        System.out.println("Start sorting...");
        long startTime = System.currentTimeMillis();
        if (printValues)
            printNumbers();
        quicksort(0, number - 1);
        System.out.println("End sorting");
        System.out.println("Time taken: "+(System.currentTimeMillis()-startTime)/1000.0 +" sec");
        if (printValues)
            printNumbers();
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }
            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public void printNumbers() {
        System.out.print("{");
        for (int i=0; i < numbers.length; i++) {
            System.out.print(numbers[i]+", ");
        }
        System.out.print("}");
        System.out.print("\n");
    }

    private void javaBuiltInSort() {
        Arrays.sort(numbers);
    }
}
