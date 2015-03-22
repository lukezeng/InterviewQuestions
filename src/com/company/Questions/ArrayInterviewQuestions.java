package com.company.Questions;

import com.company.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;

/**
 * Created by wenwzhou on 2/23/15.
 */
public class ArrayInterviewQuestions {

    public static int singleNumber(int[] A) {
        //https://oj.leetcode.com/problems/single-number/
        int num = 0;
        for(int x: A) {
            num ^= x;
        }
        System.out.println("The single number is "+num);
        return num;
    }

    /**
     * Find the products of all the integers except the integer at each index (no division allowed)
     * O(n) runtime, O(n) space
     * Edge cases: array contains zero? array length <= 1 ?
     * Solution: We create an array, populate it with the products of all the integers before each index,
     * and then multiply those products with the products after each index to get our final result
     * @param arr
     * @return
     */
    public static int[] productOfIntegerInArray(int[] arr) {
        Helper.printIntArray("Find the products of all the integers expect the one at each index: ", arr);
        int[] prodArr= new int[arr.length];
        //First loop get the product of integers before the index
        int prod = 1, i=0;
        while(i<arr.length) {
            prodArr[i] = prod;
            prod *= arr[i];
            i++;
        }
        //Go backwards to get the product of all the integers after the index, and then get the product of before and after
        i--;
        prod = 1;
        while(i>=0) {
            prodArr[i] = prodArr[i] * prod;
            prod *= arr[i];
            i--;
        }
        Helper.printIntArray("Result: ", prodArr);
        return prodArr;
    }

    /**
     * First Missing Positive
     * Runtime O(n), Space O(1)
     * @param A
     * @return
     */
    public static int firstMissingPositive(int[] A) {
        //https://leetcode.com/problems/first-missing-positive/
        int n = A.length;
        if(n==0) return 1;
        //move all k positive integer to the front: 0 ~ k-1
        int k = partition(A, n) + 1;
        //mark the existing integer 0 < val <=k as A[val-1] is negative
        for(int i=0; i<k; i++) {
            int val = Math.abs(A[i]);
            if(val <= k && A[val-1] > 0) {
                A[val-1] = -A[val-1];
            }
        }
        //find the smallest index which value in A is positive, that means the (index+1) is the first missing positive integer
        for(int i=0; i<k; i++) {
            if(A[i] > 0) {
                System.out.println("The first missing positive integer in array is "+(i+1));
                return (i+1);
            }
        }
        //all the k integer appear in array, the next positive integer is k+1
        System.out.println("The first missing positive integer in array is "+(k+1));
        return (k+1);
    }

    private static int partition(int[] A, int len) {
        int p = 0, q = len-1;
        while(p<=q) {
            while(p<len && A[p]>0)  p++;
            while(q>=0 && A[q]<=0)  q--;
            if(p<q) {
                int tmp = A[p];
                A[p] = A[q];
                A[q] = tmp;
            }
        }
        return q;
    }

    /**
     * Largest Rectangle in Histogram
     * Runtime: O(n), Space: O(n)
     * Solution: http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
     *  For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle.
     *  need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’
     * @param height
     * @return
     */
    public static int largestRectangleArea(int[] height) {
        //https://leetcode.com/problems/largest-rectangle-in-histogram/
        int n = height.length;
        if(n==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for(int i=0; i<n; i++) {
            while(stack.peek() != -1) {
                if(height[i] < height[stack.peek()]) {
                    int top = height[stack.pop()];
                    max = Math.max(max, top * (i-1-stack.peek()));
                }else {
                    break;
                }
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            max = Math.max(max, height[stack.pop()] * (n-1-stack.peek()));
        }
        System.out.println("The largest rectangle area in the histogram is "+max);
        return max;
    }

    /**
     * Longest Consequence Sequence
     * Runtime O(n), Space O(n)
     *  When insert a new element n into the hashmap, check whether the sequence next to n exist: n-1(left) and n+1(right)
     *  Update the length of sequence on n, and the other two boundaries of left/right sequence if exist
     * @param num
     * @return
     */
    public static int longestConsecutive(int[] num) {
        //https://leetcode.com/problems/longest-consecutive-sequence/
        int n = num.length;
        if(n==0) return 0;
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
        int max = 0, left = 0, right = 0, len = 0;
        for(int i=0; i<n; i++) {
            if(!map.containsKey(num[i])) {
                //insert new element n, find whether there are sequences next to num[i]
                //0 means there no adjacent sequence, and n will be the boundary point later
                left = map.containsKey(num[i]-1) ? map.get(num[i]-1) : 0; //length of sequence on the left
                right = map.containsKey(num[i]+1) ? map.get(num[i]+1) : 0; //length of sequence on the right
                //update the len of the new sequence
                len = left + right + 1;
                map.put(num[i], len);
                max = Math.max(len, max);
                //update the sequence length on the boundary points
                map.put(num[i]-left, len);
                map.put(num[i]+right, len);
            }
        }
        System.out.println("The length of the longest consequence sequence is "+max);
        return max;
    }
}
