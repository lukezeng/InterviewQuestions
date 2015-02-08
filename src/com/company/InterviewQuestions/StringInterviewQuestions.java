package com.company.interviewQuestions;

/**
 * Created by Luke on 2/8/2015.
 *
 */
public class StringInterviewQuestions {
    public static String countAndSay(int input){
        //https://oj.leetcode.com/problems/count-and-say/
        String result = "1";
        for (int i = 0; i < input; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    public static String countAndSay(String input){
        //https://oj.leetcode.com/problems/count-and-say/
        if(input == null) return null;
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i-1)==input.charAt(i)){
                count++;
            } else {
                result.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(input.charAt(input.length()-1));
        System.out.println("countAndSay converted string " + input + " to " + result.toString());
        return result.toString();
    }
}
