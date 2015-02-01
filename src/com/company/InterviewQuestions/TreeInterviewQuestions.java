package com.company.interviewQuestions;

import com.company.dataStructures.BinaryTreeNode;

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
