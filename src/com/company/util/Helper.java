package com.company.util;

import com.company.dataStructures.Interval;
import com.company.dataStructures.Node;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class Helper {
    public static void printIntArray(String prefix,int[] input){
        System.out.print(prefix);
        for(int i = 0; i< input.length-1;i++){
            System.out.print(input[i] + ", ");
        }
        System.out.print(input[input.length-1]);
        System.out.println();
    }

    public static void printLinkedList(Node root){
        if(root == null){
            System.out.println("This Linked List is null");
            return;
        }
        Node curr = root;
        System.out.print("Printing out LinkedList: ");
        while(curr.next!= null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    public static void sortIntervalByEndTime(Interval[] input){
        //This helper function is designer to sort a array of Intervals
        //After sorting, the Interval should be ascendant by end time.
        int len = input.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if(input[j].end > input[j+1].end) swapInterval(input, j, j+1);
            }
        }
    }

    public static void swap(int[] input, int a, int b){
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public static void swapInterval(Interval[] input, int a, int b){
        Interval tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
