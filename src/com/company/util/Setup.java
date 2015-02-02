package com.company.util;

import com.company.dataStructures.BinaryTreeNode;
import com.company.dataStructures.Interval;
import com.company.dataStructures.Node;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class Setup {
    public static int[] randomArray = {9,0,2,8,3,4,7,5,1,6};
    public static int[] sortedArray = {0,1,2,3,4,5,6,7,8,9};

    public static int[] getRandomArray(){
        return randomArray.clone();
    }

    public static int[] getSortedArray(){
        return sortedArray.clone();
    }

    public static Node getLinkedList(){
        Node node9 = new Node(9);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        return new Node(1, node2);
    }

    public static Node getLoopedLinkedList(){
        Node node9 = new Node(9);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node9.next = node5;
        return node1;
    }

    public static BinaryTreeNode getRandomBinaryTree(){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3, binaryTreeNode1, binaryTreeNode3);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6, binaryTreeNode5, binaryTreeNode7);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4, binaryTreeNode2, binaryTreeNode6);
        return new BinaryTreeNode(8, binaryTreeNode4, binaryTreeNode9);
    }

    public static BinaryTreeNode getBinarySearchTree(){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2, binaryTreeNode1, binaryTreeNode3);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6, binaryTreeNode5, binaryTreeNode7);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4, binaryTreeNode2, binaryTreeNode6);
        return new BinaryTreeNode(8, binaryTreeNode4, binaryTreeNode9);
    }

    public static Interval[] getClassIntervals(){
        Interval[] result = new Interval[9];
        result[0] = new Interval(3, 4);
        result[1] = new Interval(1, 2);
        result[2] = new Interval(5, 6);
        result[3] = new Interval(1, 20);
        result[4] = new Interval(11, 12);
        result[5] = new Interval(13, 14);
        result[6] = new Interval(8, 9);
        result[7] = new Interval(3, 8);
        result[8] = new Interval(20, 21);
        return result;
    }
}
