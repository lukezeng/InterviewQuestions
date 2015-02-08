package com.company.interviewQuestions;

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
        int[][] result = new int[m][n];
        for(int i = 0; i<n; i++){
            result[0][i] = 1;
        }
        for(int i = 0; i < m;i++){
            result[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        System.out.println("For a "+m+" x "+n +" matrix, a robot has " + result[m-1][n-1] + " unique ways.");
        return result[m-1][n-1];
    }
}
