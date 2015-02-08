package com.company.interviewQuestions;

import com.company.dataStructures.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.company.util.Helper.*;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class GreedyAlgorithm {
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; ) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.set(i + 1, new Interval(intervals.get(i).start, Math.max(intervals.get(i + 1).end, intervals.get(i).end)));
                intervals.remove(i);
            } else i++;
        }
        return intervals;
    }
    public static int maxClass(Interval[] input){
        sortIntervalByEndTime(input);
        int result = 1;
        int currEndTime = input[0].end;
        for (int i = 1; i < input.length; i++) {
            if(input[i].start > currEndTime){
                result++;
                currEndTime = input[i].end;
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
    public static int trapRainWater(int[] input){
        int result = 0;
        int left = 0, right = input.length-1;
        int min = 0;
        while(right > left){
            min = Math.min(input[left], input[right]);
            if(input[left]==min){
                while(input[left]<=min){
                    result += min - input[left];
                    left++;
                }
            }
            if(input[right] == min){
                while(input[right]<=min){
                    result += min - input[right];
                    right--;
                }
            }
        }
        return result;
    }
}
