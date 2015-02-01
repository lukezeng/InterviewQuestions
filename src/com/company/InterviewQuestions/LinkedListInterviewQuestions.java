package com.company.interviewQuestions;

import com.company.dataStructures.Node;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class LinkedListInterviewQuestions {
    public static Node reversLinkedList(Node root){
        if(root == null || root.next == null) return root;
        Node ptr = root, prev = null;
        while(ptr.next != null){
            Node tmp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = tmp;
        }
        ptr.next = prev;
        return ptr;
    }

    public static Node reverseLinkedListR(Node node){
        if(node == null || node.next == null) return node;
        Node remainingList = reverseLinkedListR(node.next);
        node.next.next = node;
        node.next = null;
        return remainingList;
    }

    public static boolean isLoopedLinkedList(Node root){
        if(root == null || root.next == null) return false;
        Node slow = root, fast = root;
        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                System.out.println("This is a looped linked list.");
                return true;
            } else if(fast == null){
                System.out.println("This is not a looped linked list.");
                return false;
            }
        }
        System.out.println("This is not a looped linked list.");
        return false;
    }
}
