package com.company.interviewQuestions;

import java.util.ArrayList;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class DynamicProgramming {
    public static int totalPossibleWays(int input){
        if(input==1 || input == 2) return input;
        int[] memory = new int[input+1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        for (int i = 3; i < input+1; i++) {
            memory[i] = memory[i-1] + memory[i-2];
        }
        System.out.println("The total possible way to climb a " + input + " stairs is " + memory[input]);
        return memory[input];
    }
    public static int buySellStock(int[] prices){
        int max = 0, len = prices.length, curr = 0;
        if(len==1) return 0;
        int[] delta = new int[len];
        for (int i = 1; i < len; i++) {
            delta[i] = prices[i] - prices[i-1];
        }
        for(int item : delta){
            curr = Math.max(curr + item, 0);
            if(curr > max) max = curr;
        }
        System.out.println("The maximum profit out of the array is " + max);
        return max;
    }
    public static int uniquePath(int m,int n){
        //https://oj.leetcode.com/problems/unique-paths/
        int[][] result = new int[m][n];
        for(int i = 0; i<n; i++) result[0][i] = 1;
        for(int i = 0; i < m;i++) result[i][0] = 1;
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        System.out.println("For a "+m+" x "+n +" matrix, a robot has " + result[m-1][n-1] + " unique ways.");
        return result[m-1][n-1];
    }
    public static int maxSubArray(int[] input){
        if(input == null) return -1;
        if(input.length == 1) return input[0];
        int max = input[0], curr = input[0];
        for(int i = 1; i < input.length; i++){
            curr = Math.max(0, curr+input[i]);
            if(curr > max) max = curr;
        }
        return max;
    }
    public static int longestIncreaseSubsequence(int[] input){
        int[] memory = new int[input.length];
        memory[0] = 1;
        int max = 1;
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if(input[i] > input[j] && memory[i] < memory[j]+1){
                    memory[i]=memory[j]+1;
                    if(memory[i]> max) max = memory[i];
                }
            }
        }
        return max;
    }
    public static int longestCommonSubstring(String a, String b){
        a = " "+a;
        b = " "+b;
        int[][] memory = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++){
                memory[i][j] = 0;
            }
        }
        for (int i = 1; i < a.length(); i++) {
            for(int j = 1; j < b.length(); j++){
                if(a.charAt(i)==b.charAt(j)){
                    memory[i][j] = memory[i-1][j-1]+1;
                } else {
                    memory[i][j] = Math.max(memory[i-1][j],memory[i][j-1]);
                }
            }
        }
        for (int i = 0; i < a.length(); i++) {
            for(int j = 0; j < b.length(); j++){
                System.out.print(memory[i][j] + ",");
            }
            System.out.println();
        }
        return memory[a.length()-1][b.length()-1];
    }
}
