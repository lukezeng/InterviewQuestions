package com.company;

/**
 * Created by Luke on 2/1/2015.
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


}
