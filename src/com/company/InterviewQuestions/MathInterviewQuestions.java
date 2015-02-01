package com.company.interviewQuestions;

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
}
