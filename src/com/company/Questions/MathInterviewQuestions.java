package com.company.Questions;

import com.company.util.Helper;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Luke on 2/1/2015.
 *
 */
public class MathInterviewQuestions {
    public static int pow(int base, int power){
        if(power == 0) return 1;
        if(base == 1 || base == 0 || power == 1) return base;
        if((power % 2) == 0){
            return pow(base*base, power/2);
        } else {
            return pow(base*base,power/2)*base;
        }
    }

    public static double squareRoot(double x){
        if(x < 0) return -1;
        if(x == 0 || x == 1) return x;
        double start = 0;
        double end;
        double mid = 0;
        double precision = 0.0001;
        if(x < 1){
            end = 1;
        } else {
            end = x;
        }
        while((end - start) >= precision){
            mid = (end+start)/2;
            if(mid*mid > x){
                end = mid;
            } else {
                start = mid;
            }
        }
        System.out.println("We found the square root of " + x + " is " + mid);
        return mid;
    }

    public static int divided(int input,int divider){
        if(divider == 0) return -1;
        if(input < 0 && divider < 0) return divided(-input, -divider);
        if(input<0) return -divided(-input, divider);
        if(divider<0) return -divided(input, -divider);
        int result = 0;
        while(input > 0) {
            input -= divider;
            result++;
        }
        return result;
    }

    /**
     * Find Gray Code
     * Backtracking, recursive
     * Runtime O(2^n) Space O(1)
     * @param n
     * @return
     */
    public static ArrayList<Integer> grayCode(int n) {
        //https://leetcode.com/problems/gray-code/
        ArrayList<Integer> res = new ArrayList<Integer>();
        int num = 0;
        findGray(n, num, false, res);
        Helper.printArrayList("The gray code sequence when n=" + n, res);
        return res;
    }
    private static void findGray(int n, int num, boolean flip, ArrayList<Integer> res) {
        if(n==0) {
            res.add(num);
            return;
        }
        int[] digit = new int[] {0,1};
        if(flip) {
            digit[0] = 1;
            digit[1] = 0;
        }
        int x = num | digit[0]<<n-1;
        findGray(n-1, x, false, res);
        int y = num | digit[1]<<n-1;
        findGray(n-1, y, true, res);
    }

    /**
     * Combination k out of n
     */
    public static List<List<Integer>> combine(int n, int k) {
        //https://leetcode.com/problems/combinations/
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==0 || k==0) return res;
        List<Integer> list = new ArrayList<Integer>();
        findComb(n, k, 1, list, res);
        System.out.println("Combination k="+k+" out of n="+n);
        for(List<Integer> l: res) {
            Helper.printArrayList(" ", l);
        }
        return res;
    }
    private static void findComb(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        for(int i=start; i<=n; i++) {
            List<Integer> copy = new ArrayList<Integer>(list);
            copy.add(i);
            if(k==1) {
                res.add(copy);
            }else {
                findComb(n, k-1, i+1, copy, res);
            }
        }
    }
}
