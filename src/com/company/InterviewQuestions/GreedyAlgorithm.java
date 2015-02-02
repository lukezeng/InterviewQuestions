package com.company.interviewQuestions;

import com.company.dataStructures.Interval;

import static com.company.util.Helper.*;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class GreedyAlgorithm {

    public static int maxClass(Interval[] input){
        sortIntervalByEndTime(input);
        int result = 1;
        int currEndTime = input[0].endTime;
        for (int i = 1; i < input.length; i++) {
            if(input[i].startTime > currEndTime){
                result++;
                currEndTime = input[i].endTime;
            }
        }
        return result;
    }

    public static boolean canJump(int[] A) {
        int len = A.length;
        if(len == 1) return true;
        if(A[0] == 0) return false;
        int reachable = A[0];
        for(int i = 0; i < len && i <= reachable; i++){
            if(i+A[i] > reachable) reachable = i+A[i];
        }
        return reachable >= len - 1;
    }


}
