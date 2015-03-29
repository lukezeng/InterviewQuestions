package com.company.Questions;

import com.company.util.Helper;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * Handle the case when power is negative
     */
    public static double pow(double base, int power) {
        if(power==0) return 1;
        double val = pow(base, power/2);
        if(power%2==0) return val * val;
        if(power > 0)
            return val * val * base;
        else
            return val * val / base;
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

    /**
     * bit manipulation of square root
     */
    public static int sqrt(int x) {
        long ans = 0;
        long bit = (1L<<15);
        while(bit > 0) {
            ans |= bit;
            if(ans * ans > x)
                ans ^= bit;
            bit >>= 1;
        }
        System.out.println("We found the square root of " + x + " is (int)" + ans);
        return (int)ans;
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

    public static String fractionToDecimal(int numerator, int denominator) {
        //https://leetcode.com/problems/fraction-to-recurring-decimal/
        if(numerator==0)
            return "0";
        StringBuilder res = new StringBuilder();
        //append sign + or -
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        //convert to long in order to avoid overflow during abs
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        //integral part
        res.append(num/den);
        num %= den;
        if(num == 0) return res.toString();
        //decimal part
        res.append(".");
        //Use hashmap to track possible repeat decimal number. Key is the reminder, value is the start position of possible repeat number
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(num > 0) {
            map.put((int)num, res.length());
            num *= 10;
            res.append(num / den);
            num %= den;
            Integer index = map.get((int)num);
            if(index!=null) {
                //find the repeat pattern
                res.insert(index, "(");
                res.append(")");
                break;
            }
        }
        System.out.println(numerator+"/"+denominator+" = "+res.toString());
        return res.toString();
    }

    /**
     * Remember the busy columns and diagonals and recursively try to put the queen into the next row
     */
    public static List<String[]> solveNQueens(int n) {
        //https://leetcode.com/problems/n-queens/
        List<String[]> res = new ArrayList<String[]>();
        placeQueen(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], res);
        System.out.println("Total number of distinct N-Queens solutions are "+res.size());
        return res;
    }
    private static void placeQueen(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<String[]> res) {
        if(r==board.length)
            res.add(board.clone());
        else {
            for(int c=0; c<board.length; c++) {
                int idx1 = r-c+board.length, idx2 = 2*board.length-r-c-1; //idx1 tracks diagonal index, idx2 tracks clinodiagoal index
                if(!cols[c] && !d1[idx1] && !d2[idx2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.'); row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true; d1[idx1] = true; d2[idx2] = true;
                    placeQueen(r+1, cols, d1, d2, board, res);
                    cols[c] = false; d1[idx1] = false; d2[idx2] = false;
                }
            }
        }
    }
}
