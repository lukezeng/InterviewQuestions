package com.company;

import com.company.Questions.*;
import com.company.algorithms.SearchingAlgorithm;
import com.company.algorithms.SortingAlgorithm;
import com.company.util.Helper;
import com.company.util.Setup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class Testing {
    public static void sortingAlgorithms(){
        System.out.println("--------------------------------- Sorting Algorithm---------------------------------------");
        int[] colorArr = {1,2,0,1,2,0};
        int[] arr = Setup.getRandomArray();
        Helper.printIntArray("Before sorting: \t", arr);
        SortingAlgorithm.bubbleSort(arr);
        Helper.printIntArray("After BubbleSort: \t", arr);
        arr = Setup.getRandomArray();
        SortingAlgorithm.mergeSort(arr);
        Helper.printIntArray("After MergeSort: \t", arr);
        arr = Setup.getRandomArray();
        SortingAlgorithm.quickSort(arr);
        Helper.printIntArray("After QuickSort: \t", arr);
        SortingAlgorithm.sortColor(colorArr);
        for(int i = 0;i<colorArr.length-1;i++){
            System.out.print(colorArr[i] + ",");
        }
        System.out.println();
        SortingAlgorithm.maximumGap(new int[]{10, 1, 9, 4, 2, 3});
        System.out.println();
        System.out.println("The largest number could be formed is "+SortingAlgorithm.largestNumber(new int[] {0, 0}));
        System.out.println("The largest number could be formed is " + SortingAlgorithm.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public static void searchingAlgorithms(){
        System.out.println("--------------------------------- Searching Algorithm---------------------------------------");
        int[] arr = Setup.getSortedArray();
        SearchingAlgorithm.binarySearch(arr, 5);
        SearchingAlgorithm.binarySearch(arr, 0);
        SearchingAlgorithm.binarySearch(arr, 9);
        SearchingAlgorithm.binarySearch(arr, -1);
        SearchingAlgorithm.breathFirstSearch(Setup.getBinarySearchTree(), 5);
        System.out.println();
        SearchingAlgorithm.breathFirstSearch(Setup.getBinarySearchTree(), -5);
        System.out.println();
        SearchingAlgorithm.depthFirstSearch(Setup.getBinarySearchTree(), 5);
        System.out.println();
        SearchingAlgorithm.depthFirstSearch(Setup.getBinarySearchTree(), -5);
        System.out.println();
    }

    public static void mathInterviewQuestions(){
        System.out.println("--------------------------------- Math Interview Questions---------------------------------------");
        MathInterviewQuestions.squareRoot(9);
        MathInterviewQuestions.squareRoot(0.5);
        MathInterviewQuestions.sqrt(2);
        System.out.println("2 to the 3rd power is : " + MathInterviewQuestions.pow(2, 3));
        System.out.println("2 to the 4th power is : " + MathInterviewQuestions.pow(2, 4));
        System.out.println("2 to the 10th power is : " + MathInterviewQuestions.pow(2, 10));
        System.out.println("2 to the 10th power is : " + MathInterviewQuestions.pow(2, 10));
        System.out.println("2 to the -2th power is : " + MathInterviewQuestions.pow(2.0, -2));
        System.out.println("10 divided by 5 is : " + MathInterviewQuestions.divided(10, 5));
        System.out.println("-15 divided by 5 is : " + MathInterviewQuestions.divided(-15, 5));
        System.out.println("10 divided by -2 is : " + MathInterviewQuestions.divided(10, -2));
        System.out.println("10 divided by 0 is : " + MathInterviewQuestions.divided(10, 0));
        System.out.println();
        MathInterviewQuestions.grayCode(2);
        MathInterviewQuestions.grayCode(3);
        System.out.println();
        MathInterviewQuestions.combine(4, 2);
        System.out.println();
        MathInterviewQuestions.fractionToDecimal(1, 33);
        System.out.println();
        MathInterviewQuestions.solveNQueens(4);
        System.out.println();
    }

    public static void linkedListInterviewQuestions(){
        System.out.println("--------------------------------- LinkedList Interview Questions---------------------------------------");
        Helper.printLinkedList(Setup.getLinkedList());
        Helper.printLinkedList(LinkedListInterviewQuestions.reversLinkedList(Setup.getLinkedList()));
        Helper.printLinkedList(LinkedListInterviewQuestions.reverseLinkedListR(Setup.getLinkedList()));
        LinkedListInterviewQuestions.isLoopedLinkedList(Setup.getLinkedList());
        LinkedListInterviewQuestions.isLoopedLinkedList(Setup.getLoopedLinkedList());
        System.out.println();
    }

    public static void stringInterviewQuestions(){
        System.out.println("--------------------------------- LinkedList Interview Questions---------------------------------------");
        StringInterviewQuestions.countAndSay("aaabbbbbbbbbc");
        StringInterviewQuestions.countAndSay("aaabbbbbbbbb");
        StringInterviewQuestions.countAndSay("33334444455555");
        StringInterviewQuestions.countAndSay("3344556667777");
        StringInterviewQuestions.countAndSay(3);
        System.out.println();
        StringInterviewQuestions.anagrams(new String[] {"",""});
        StringInterviewQuestions.anagrams(new String[] {"dog","cat","god","tac","bug"});
        System.out.println();
        StringInterviewQuestions.findSubstring("barfoothefoobarman", new String[] {"foo","bar"});
        System.out.println();
        System.out.println(StringInterviewQuestions.constructDate(19, 19, 3));
        System.out.println(StringInterviewQuestions.constructDate(2, 2, 28));
        System.out.println();
        StringInterviewQuestions.accessCode(new String[] {"x","y","xy","yy","","yx"});
        System.out.println();
        Set<String> dict = new HashSet<String>();
        dict.add("cat"); dict.add("cats"); dict.add("and");  dict.add("sand");  dict.add("dog");
        System.out.println("The string can "+(StringInterviewQuestions.wordBreak("catsanddog", dict) ? "" : "not ")+"be break by words in dictionary");
        StringInterviewQuestions.wordBreakII("catsanddog", dict);
        System.out.println();
        StringInterviewQuestions.generateParentheses(3);
    }

    public static void treeInterviewQuestions(){
        System.out.println("--------------------------------- Tree Interview Questions---------------------------------------");
        System.out.println("Given binary search tree, validateBinarySearchTree is returning: " + TreeInterviewQuestions.validateBinarySearchTree(Setup.getBinarySearchTree()));
        System.out.println("Given random binary tree, validateBinarySearchTree is returning: " + TreeInterviewQuestions.validateBinarySearchTree(Setup.getRandomBinaryTree()));
        System.out.println("Given binary binary tree, maxDepth is returning: " + TreeInterviewQuestions.maxDepth(Setup.getRandomBinaryTree()));
        System.out.print("Given preOrderTravers a binary search tree: ");
        TreeInterviewQuestions.preOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        System.out.print("Given inOrderTravers a binary search tree: ");
        TreeInterviewQuestions.inOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        System.out.print("Given postOrderTravers a binary search tree: ");
        TreeInterviewQuestions.postOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        TreeInterviewQuestions.printPath(TreeInterviewQuestions.convertSortedArrayToBST(Setup.getSortedArray(), 0, Setup.getSortedArray().length - 1));
        System.out.println();
        TreeInterviewQuestions.printPath(Setup.getBinarySearchTree());
        TreeInterviewQuestions.commonAncestor(Setup.getBinarySearchTree(), 1, 3);
        System.out.println();
        TreeInterviewQuestions.rightSideView(Setup.getRandomBinaryTree());
    }

    public static void recursiveInterviewQuestions(){
        System.out.println("--------------------------------- Recursive Interview Questions---------------------------------------");
        RecursiveInterviewQuestions.generateParentheses(3);
        System.out.println();
        int[] input = {1,2,3};
        ArrayList<String> powerSet = RecursiveInterviewQuestions.powerSet(input);
        for(String s:powerSet){
            System.out.print("{" + s + "}, ");
        }
        System.out.println();
        ArrayList<String> stringPermutation = RecursiveInterviewQuestions.permutation("abc");
        for(String s:stringPermutation){
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    public static void greedyAlgorithm(){
        System.out.println("--------------------------------- Greedy Algorithm Interview Questions---------------------------------------");
        int[] arr1 = {1,0,0,0,0,0};
        int[] arr2 = {3,2,3,4,2,1};
        System.out.println("Given unjumpable array, canJump should return false : " + GreedyAlgorithm.canJump(arr1));
        System.out.println("Given jumpable array, canJump should return true: " + GreedyAlgorithm.canJump(arr2));
        System.out.println("Given interval array, maxClass should return 7 : " + GreedyAlgorithm.maxClass(Setup.getClassIntervals()));
        System.out.println("Given interval array, maxClass should return 3 : " + GreedyAlgorithm.maxClass(Setup.getOtherClassIntervals()));
        GreedyAlgorithm.mergeIntervals(Setup.getIntervalsArrayList());
        System.out.println("Given sorted Integer array, trapRainWater should return should 0 : " + GreedyAlgorithm.trapRainWater(Setup.getSortedArray()));
        System.out.println("Given sorted Integer array, trapRainWater should return should 27 : " + GreedyAlgorithm.trapRainWater(Setup.getRandomArray()));
        System.out.println();
    }

    public static void dynamicProgramming(){
        System.out.println("--------------------------------- Dynamic Programming Interview Questions---------------------------------------");
        int[] maxSub = {-2,1,-3,4,-1,2,1,-5,4};
        DynamicProgramming.totalPossibleWays(10);
        DynamicProgramming.totalPossibleWays(20);
        DynamicProgramming.buySellStock(Setup.getRandomArray());
        DynamicProgramming.buySellStock(Setup.getSortedArray());
        DynamicProgramming.buySellStockI(Setup.getSortedArray());
        DynamicProgramming.uniquePath(1, 1);
        DynamicProgramming.uniquePath(2,2);
        DynamicProgramming.uniquePath(3, 3);
        DynamicProgramming.uniquePath(15, 15);
        DynamicProgramming.maxSubArray(maxSub);
        System.out.println(DynamicProgramming.longestIncreaseSubsequence(maxSub));
        System.out.println(DynamicProgramming.longestCommonSubstring("ACCGGGTTAC", "AGGACCA"));
        System.out.println();
        DynamicProgramming.numDecodings("1212");
        System.out.println();
        DynamicProgramming.calculateMinimumHP(Setup.getDungeonRooms());
        System.out.println();
        DynamicProgramming.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        DynamicProgramming.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }

    public static void arrayInterviewQuestions() {
        System.out.println("--------------------------------------- Array Interview Questions ---------------------------------------------");
        ArrayInterviewQuestions.singleNumber(new int[]{2, 2, 1, 3, 1, 4, 4, 4, 3, 2, 3, 1});
        System.out.println();
        ArrayInterviewQuestions.productOfIntegerInArray(new int[]{1, 2, 6, 5, 9});
        System.out.println();
        ArrayInterviewQuestions.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println();
        ArrayInterviewQuestions.largestRectangleArea(new int[]{2, 3, 3, 4, 5});
        ArrayInterviewQuestions.largestRectangleArea(new int[]{5, 4, 3, 3, 2});
        System.out.println();
        ArrayInterviewQuestions.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println();
        ArrayInterviewQuestions.workingHour(new int[][]{new int[]{1, 3}, new int[]{3, 6}});
        ArrayInterviewQuestions.workingHour(new int[][]{new int[]{10, 14}, new int[]{4, 18}, new int[]{19, 20}, new int[]{19, 20}, new int[]{13, 20}});
        System.out.println();
        ArrayInterviewQuestions.searchMatrix(new int[][]{new int[]{1, 3, 5}, new int[]{10, 11, 16}}, 3);
    }
}
