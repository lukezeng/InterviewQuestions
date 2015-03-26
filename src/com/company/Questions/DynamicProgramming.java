package com.company.Questions;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;


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

    /**
     * Buy and sell only once, find the max profit
     * O(n) runtime O(1) space
     * @param prices
     * @return
     */
    public static int buySellStockI(int[] prices) {
        if(prices.length<=1) return 0;
        int lowest = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
        }
        System.out.println("The maximum profit out of the array is " + maxProfit);
        return maxProfit;
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

    public static int numDecodings(String s) {
        //https://leetcode.com/problems/decode-ways/
        if(s.length()==0) return 0;
        int n = s.length();
        int[] ways = new int[n+1];
        ways[n] = 1;
        ways[n-1] = s.charAt(n-1)=='0' ? 0 : 1;
        for(int i=n-2; i>=0; i--) {
            if(s.charAt(i)=='0') continue; //zero must be combined with the next number
            //ways[i+1] --> add current letter without combining the previous number
            //ways[i+2] --> add current letter by combining with previous number
            ways[i] = Integer.parseInt(s.substring(i, i+2))<=26 ? (ways[i+1]+ways[i+2]) : ways[i+1];
        }
        System.out.println("There are "+ways[0]+" ways to decode string "+s);
        return ways[0];
    }

    /**
     *
     * Use the equation from leetcode solution: min_HP_on_exit = min(D[i+1][j], D[i][j+1])
     * Comment out mine, basically they are the same
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        //https://leetcode.com/problems/dungeon-game/
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m-1][n-1] = dungeon[m-1][n-1]>=0 ? 1 : (1-dungeon[m-1][n-1]);
        for(int i=m-2; i>=0; i--) {
            health[i][n-1] = Math.max(health[i+1][n-1]-dungeon[i][n-1], 1);
            // health[i][n-1] = dungeon[i][n-1]>=health[i+1][n-1] ? 1 : health[i+1][n-1]-dungeon[i][n-1];
        }
        for(int j=n-2; j>=0; j--) {
            health[m-1][j] = Math.max(health[m-1][j+1]-dungeon[m-1][j], 1);
            // health[m-1][j] = dungeon[m-1][j]>=health[m-1][j+1] ? 1 : health[m-1][j+1]-dungeon[m-1][j];
        }
        for(int i = m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                int beHealth = Math.min(health[i+1][j], health[i][j+1]);
                health[i][j] = Math.max(beHealth-dungeon[i][j], 1);
                // health[i][j] = dungeon[i][j]>=beHealth ? 1 : beHealth-dungeon[i][j];
            }
        }
        System.out.println("The knight has to be on level "+health[0][0]+" in order to save the princess!");
        return health[0][0];
    }

    /**
     * Interleaving String
     * Runtime O(mn) space O(mn)
     * Could optimize space to O(n) by only use one array
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        //https://leetcode.com/problems/interleaving-string/
        int m = s1.length();
        int n = s2.length();
        int size = s3.length();
        if(m+n != size) return false;
        //dp table. f[i][j] means to take the first i chars from s1 and first j from s2 to make s3[0...i+j-1]
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        //take 0 chars from s2 and i chars from s1
        for(int i=1; i<=m; i++) {
            f[i][0] = f[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1));
        }
        //take j chars from s2 and 0 chars from s1
        for(int j=1; j<=n; j++) {
            f[0][j] = f[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1));
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                //either ith in s1 match to i+j-1 in s3, or jth in s2 match to i+j-1 in s3
                f[i][j] = f[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)) || f[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        System.out.println("String '"+s3+"' is"+(f[m][n] ? "" : " not")+" formed by interleaving '"+s1+"' and '"+s2+"'");
        return f[m][n];
    }
}
