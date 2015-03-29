package com.company.algorithms;

import com.company.util.Helper;
import static com.company.util.Helper.swap;
import static java.lang.System.arraycopy;
import java.util.Arrays;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class SortingAlgorithm {
    public static void bubbleSort(int[]input){
        for (int i = 0; i < input.length-1; i++) {
            for (int j = 0; j < input.length-i-1; j++) {
                if(input[j]>input[j+1]) swap(input, j, j + 1);
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
                swap(input, wall, i);
                wall++;
            }
        }
        swap(input, wall, right);
        quickSort(input, left, wall-1);
        quickSort(input, wall+1, right);
    }

    public static void sortColor(int[] input){
        //https://oj.leetcode.com/problems/sort-colors/
        int zeroEnd = 0, twoStart = input.length-1;
        for(int i = 0; i <= twoStart;){
            if(input[i] == 0) {
                Helper.swap(input, i, zeroEnd);
                zeroEnd++;
		i++;
            }else if(input[i]==2){
                Helper.swap(input, i, twoStart);
                twoStart--;
            }else {
		i++;
	    }
        }
    }

    /**
     * Bucket Sort
     * Runtime O(n) Space O(n)
     */
    public static int maximumGap(int[] num) {
        //https://leetcode.com/problems/maximum-gap/
        int n = num.length;
        if(n<=1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        //minimum gap
        int gap = (int)Math.ceil((double)(max-min) / (n-1));
        //n-1 buckets
        int[] bucket_min = new int[n-1];//store min value in each bucket
        int[] bucket_max = new int[n-1]; //store max value in each bucket
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        //fill the elements into bucket
        for(int d: num) {
            if(d==min || d==max)
                continue;
            int idx = (d-min) / gap; //get the bucket index
            bucket_min[idx] = Math.min(d, bucket_min[idx]);
            bucket_max[idx] = Math.max(d, bucket_max[idx]);
        }
        //scan the bucket for the max gap
        int maxgap = 0;
        int previous = min;
        for(int i=0; i<n-1; i++) {
            //skip the empty bucket
            if(bucket_min[i]==Integer.MAX_VALUE && bucket_max[i]==Integer.MIN_VALUE)
                continue;
            maxgap = Math.max(maxgap, bucket_min[i] - previous);
            previous = bucket_max[i];
        }
        maxgap = Math.max(maxgap, max-previous);
        System.out.println("The max gap between the successive elements is "+maxgap);
        return maxgap;
    }
}




