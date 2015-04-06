package com.company.Questions;

import com.company.util.Helper;

import java.util.*;

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

    /**
     * Runtime O(n) Space o(m) (n is len of S, m is len of L)
     */
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        //https://leetcode.com/problems/substring-with-concatenation-of-all-words/
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(L.length>0 && L[0].length()>0 && S.length()>=(L.length*L[0].length())) {
            final HashMap<String, Integer> dict = new HashMap<String, Integer>();
            //build dict for word in L
            for(String s: L) {
                dict.put(s, dict.containsKey(s) ? dict.get(s)+1 : 1);
            }
            int len = L[0].length();
            for(int i=0; i<len; i++) {
                //make a copy of dict, and store the remaining words in the dict
                HashMap<String, Integer> map = new HashMap<String, Integer>(dict);
                //use queue to store current sequence
                LinkedList<String> queue = new LinkedList<String>();
                for(int j=i; j+len <= S.length(); j+=len) {
                    String str = S.substring(j, j+len);
                    //if the word is in the dict
                    if(dict.containsKey(str)) {
                        //add the word into sequence
                        queue.add(str);
                        //if we already have enough this word in sequence, we need to move the first this word appear in sequence
                        if(map.get(str)==0) {
                            while(!str.equals(queue.peek())) {
                                String other = queue.poll();
                                //put removed other words back into remaining words map
                                map.put(other, map.get(other)+1);
                            }
                            queue.remove();
                        }else {
                            map.put(str, map.get(str)-1);
                        }

                        if(queue.size()==L.length) {
                            //the words in sequence that matches all words in L, add the start index of sequence to result
                            result.add(j - len*(L.length-1));
                        }
                    }else {
                        queue.clear();
                        map = new HashMap<String,Integer>(dict);
                    }
                }
            }
        }
        Helper.printArrayList("The possible start position of the substring are ", result);
        return result;
    }

    /**
     * Google coding challenge
     * Construct the date string by the given three numbers. If there are multiple solution, return 'Ambiguous'
     */
    public static String constructDate(int x, int y, int z) {
        if(x==y && y==z)  return (x<10?("0"+x):x) + "/" + (y<10?("0"+y):y) + "/" + (z<10?("0"+z):z);
        List<Integer> month = new ArrayList<Integer>();
        List<Integer> day = new ArrayList<Integer>();
        List<Integer> year = new ArrayList<Integer>();
        int[] nums = new int[] {x,y,z};
        Arrays.sort(nums);
        for(int n: nums) {
            test(n, month, day, year);
        }
        if(month.size() == 3) {
            return "Ambiguous";
        }else if(month.size() == 2 && (month.get(0) != month.get(1) || day.size()>0)) {
            return "Ambiguous";
        }else if(month.size() == 1) {
            if(day.size() == 2 && day.get(0) != day.get(1)) {
                return "Ambiguous";
            }
        }
        String res = (month.get(0)<10 ? "0":"") + month.get(0) + "/";
        int d = month.size()==2 ? month.get(1) : day.get(0);
        res = res + (d<10 ? "0":"") + d + "/";
        res = res + (day.size()==2 ? day.get(1) : year.get(0));
        return res;
    }
    private static void test(int n, List<Integer> month, List<Integer> day, List<Integer> year) {
        if(n <= 12) {
            month.add(n);
        }else if(n <= getDaysInMonth(month.get(0))) {
            day.add(n);
        }else {
            year.add(n);
        }
    }
    private static int getDaysInMonth(int m) {
        if(m==2) {
            return 28;
        }else if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
            return 31;
        }else {
            return 30;
        }
    }

    /**
     * Your job is to compare a list of the access codes and find the number of distinct codes,
     * where two codes are considered to be "identical" (not distinct) if they're exactly the same, or the same but reversed.
     * The access codes only contain the letters a-z, are all lowercase, and have at most 10 characters.
     * Each set of access codes provided will have at most 5000 codes in them
     */
    public static int accessCode(String[] x) {
        if(x.length == 0) return 0;
        HashSet<String> codes = new HashSet<String>();
        for(String s: x) {
            if(!codes.contains(s) && !codes.contains(reverse(s))) {
                codes.add(s);
            }
        }
        System.out.println("There are "+codes.size()+" distinct access codes");
        return codes.size();
    }
    private static String reverse(String str) {
        if(str.length()==0) return "";
        char[] chars = str.toCharArray();
        int L=0, R=chars.length-1;
        while(L < R) {
            char c = chars[L];
            chars[L] = chars[R];
            chars[R] = c;
            L++; R--;
        }
        return new String(chars);
    }

    /**
     * BFS solution
     * Runtime O(n^2) Space O(n)
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        //https://leetcode.com/submissions/detail/23694123/
        int n = s.length();
        if(n==0 || dict==null || dict.size()==0) return false;
        Deque<Integer> queue = new LinkedList<Integer>(); //keep track the start index of the word
        Set<Integer> visited = new HashSet<Integer>(); //mark the visited node
        queue.add(0); //start from index 0
        visited.add(0);
        while(!queue.isEmpty()) {
            int curIdx = queue.poll();
            //find the word starting from current index in the rest of the string
            for(int i=curIdx+1; i<=n; i++) {
                if(visited.contains(i))
                    continue; //skip the already visited node
                else {
                    if(dict.contains(s.substring(curIdx, i))) {
                        if(i==n) return true;
                        queue.add(i);
                        visited.add(i);
                    }
                }
            }
        }
        return false;
    }

    /**
     * DFS solution
     */
    public static List<String> wordBreakII(String s, Set<String> dict) {
        List<String> sol = new ArrayList<String>();
        if(s.length()==0 || dict==null || dict.size()==0) return sol;
        for(int i=s.length()-1; i>=0; i--) {
            if(dict.contains(s.substring(i)))
                break;
            else if(i==0)
                return sol;
        }
        StringBuilder sentence = new StringBuilder();
        dfs(s, dict, 0, sentence, sol);
        Helper.printStringList("Break the string into sentences:",sol);
        return sol;
    }
    private static void dfs(String s, Set<String> dict, int start, StringBuilder sentence, List<String> sol) {
        if(start >= s.length()) {
            sentence.deleteCharAt(sentence.length()-1);
            sol.add(sentence.toString());
            return;
        }
        for(String word: dict) {
            if(word.length()<=(s.length()-start) && word.equals(s.substring(start,start+word.length()))) {
                StringBuilder copy = new StringBuilder(sentence);
                copy.append(word+" ");
                dfs(s, dict, start+word.length(), copy, sol);
            }
        }
    }

    public static List<String> generateParentheses(int n) {
        //https://leetcode.com/problems/generate-parentheses/
        List<String> sol = new ArrayList<String>();
        addParentheses("", n, 0, sol);
        Helper.printStringList("The possible combination of "+n+" parentheses is:", sol);
        return sol;
    }
    private static void addParentheses(String str, int open, int close, List<String> sol) {
        if(open==0 && close==0) {
            //all the open and close parentheses are added into string, put this combination into result
            sol.add(str);
            return;
        }
        //has more close parentheses to be added?
        if(close != 0) addParentheses(str+')', open, close-1, sol);
        //has more open parentheses to be added?
        //if yes, increase # of close to be added by one
        if(open != 0) addParentheses(str+'(', open-1, close+1, sol);
    }
}
