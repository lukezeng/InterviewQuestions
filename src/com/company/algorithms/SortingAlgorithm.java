package com.company.algorithms;

import static java.lang.System.*;
/**
 * Created by Luke on 1/31/2015.
 *
 */
public class SortingAlgorithm {
    public static void bubbleSort(int[]input){
        for (int i = 0; i < input.length-1; i++) {
            for (int j = 0; j < input.length-i-1; j++) {
                if(input[j]>input[j+1]) Swap(input, j, j+1);
            }
        }
    }

    public static void mergeSort(int[] input){
        mergeSort(input, 0, input.length - 1);
    }

    private static void mergeSort(int[] input, int low, int high){
        if(high <= low) return;
        int mid = (low + high)/2;
        mergeSort(input, low, mid);
        mergeSort(input, mid + 1, high);
        Partition(input, low, mid, high);
    }

    private static void Partition(int[] input, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid+1, k = 0;
        while(i < mid+1 && j <= high){
            if(input[i] < input[j]){
                tmp[k] = input[i];
                i++;
            } else {
                tmp[k] = input[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            tmp[k] = input[i];
            i++;
            k++;
        }
        while(j <= high){
            tmp[k] = input[j];
            j++;
            k++;
        }
        arraycopy(tmp, 0, input, low, tmp.length);
    }

    public static void quickSort(int[] input){
        quickSort(input, 0, input.length-1);
    }

    public static void quickSort(int[] input, int left, int right){
        if(right<=left) return;
        int pivot = input[right];
        int wall = left;
        for (int i = left; i <right; i++) {
            if(input[i] < pivot){
                Swap(input, wall, i);
                wall++;
            }
        }
        Swap(input, wall, right);
        quickSort(input, left, wall-1);
        quickSort(input, wall+1, right);
    }

    //Helpers
    private static void Swap(int[] input, int a, int b){
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}




