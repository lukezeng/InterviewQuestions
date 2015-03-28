package com.company.Questions;

import com.company.util.Helper;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * Runtime O(n), Space O(n)
     */
    public static ArrayList<String> anagrams(String[] strs) {
        //https://leetcode.com/problems/anagrams/
        HashMap<String, String> pairs = new HashMap<String, String>();
        HashMap<String, String> remain = new HashMap<String, String>();
        ArrayList<String> list = new ArrayList<String>();
        for(String str: strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            if(key.length==0) //handle empty string, use null as key in hash map
                key = null;
            String k = (key!=null) ? new String(key) : null;
            String preStr = pairs.put(k, str);
            if(preStr != null) {
                list.add(preStr);
                remain.put(k, str);
            }
        }
        list.addAll(remain.values());
        Helper.printStringList("Anagrams strings are: ", list);
        return list;
    }
}
