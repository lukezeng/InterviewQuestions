package com.company.interviewQuestions;

import com.company.dataStructures.BinaryTreeNode;

import java.util.ArrayList;

/**
 * Created by Luke on 2/1/2015.
 *
 */
public class TreeInterviewQuestions {
    public static boolean validateBinarySearchTree(BinaryTreeNode root){
        return validateBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBinarySearchTree(BinaryTreeNode node, int min, int max) {
        return node == null || !(node.val > max || node.val < min) && validateBinarySearchTree(node.left, min, node.val) && validateBinarySearchTree(node.right, node.val, max);
    }

    public static int maxDepth(BinaryTreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)+1);
    }

    public static void printPath(BinaryTreeNode root){
        if(root == null) return;
        ArrayList<BinaryTreeNode> curr = new ArrayList<BinaryTreeNode>();
        printPath(root, curr);
    }

    private static void printPath(BinaryTreeNode node, ArrayList<BinaryTreeNode> curr){
        curr.add(node);
        if(node.left == null&&node.right==null) {
            for(BinaryTreeNode item : curr){
                System.out.print(item.val + ",");
            }
            System.out.println(); 
        }
        if(node.left!= null) printPath(node.left, curr);
        if(node.right!= null) printPath(node.right, curr);
        curr.remove(node);
    }

    public static void inOrderTraverse(BinaryTreeNode node){
        if(node == null) return;
        inOrderTraverse(node.left);
        System.out.print(node.val + ", ");
        inOrderTraverse(node.right);
    }

    public static void preOrderTraverse(BinaryTreeNode node){
        if(node == null) return;
        System.out.print(node.val + ", ");
        inOrderTraverse(node.left);
        inOrderTraverse(node.right);
    }

    public static void postOrderTraverse(BinaryTreeNode node){
        if(node == null) return;
        inOrderTraverse(node.left);
        inOrderTraverse(node.right);
        System.out.print(node.val + ", ");
    }
}
