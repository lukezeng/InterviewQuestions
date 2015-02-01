package com.company;

import com.company.dataStructure.Node;

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
}
