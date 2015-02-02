package com.company.interviewQuestions;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class RecursiveInterviewQuestions {
    public static void generateParentheses(int input){
        System.out.println("Generating all possible Parentheses with " + input + " pairs of them: ");
        generateParentheses(input, 0, "");
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
