package com.company.interviewQuestions;

import java.util.ArrayList;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class RecursiveInterviewQuestions {
    public static ArrayList<String> powerSet(int[] input) {
        return powerSet(input,input.length,null);
    }

    private static ArrayList<String> powerSet(int[] input, int n, ArrayList<String>  ps){
        if(n == 0){
            if(ps == null) ps = new ArrayList<String>();
            ps.add(" ");
            return ps;
        }
        ps = powerSet(input, n-1, ps);
        ArrayList<String> tmp = new ArrayList<String>();
        for(String s : ps){
            if(s == " ") {
                tmp.add("" + input[n-1]);
            } else {
                tmp.add(s + input[n-1]);
            }
        }
        ps.addAll(tmp);
        return ps;
    }

    public static void generateParentheses(int input){
        System.out.println("Generating all possible Parentheses with " + input + " pairs of them: ");
        generateParentheses(input, 0, "");
    }

    public static ArrayList<String> permutation(String input){
        ArrayList<String> result = new ArrayList<String>();
        permutation(input, result, "");
        return result;
    }

    private static void permutation(String input, ArrayList<String> result, String prefix){
        int len = input.length();
        if(len==0){
            result.add(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                permutation(input.substring(0, i) + input.substring(i+1),result, prefix + input.charAt(i));
            }
        }
    }


    private static void generateParentheses(int  remainingLeft, int remainingRight, String curr){
        if(remainingLeft == 0 && remainingRight == 0) {
            System.out.println(curr);
            return;
        }
        if(remainingLeft > 0) generateParentheses(remainingLeft-1, remainingRight+1, curr+"(");
        if(remainingRight > 0)  generateParentheses(remainingLeft, remainingRight - 1, curr + ")");
    }
}
