package com.company.dataStructure;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class Node {
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }

}
