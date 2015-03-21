package com.company.Questions;

import com.company.util.Helper;

import java.util.ArrayList;
import java.util.List;

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

}
