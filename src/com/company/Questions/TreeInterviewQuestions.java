package com.company.Questions;

import com.company.dataStructures.BinaryTreeNode;
import com.company.util.Helper;

import java.util.*;

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

    public static BinaryTreeNode convertSortedArrayToBST(int[] input, int left, int right){
        if(right < left) return null;
        if(right == left) return new BinaryTreeNode(input[left]);
        int mid = (left + right)/2;
        BinaryTreeNode node = new BinaryTreeNode(input[mid]);
        node.left = convertSortedArrayToBST(input, left, mid-1);
        node.right = convertSortedArrayToBST(input, mid+1, right);
        return node;
    }

    public static BinaryTreeNode commonAncestor(BinaryTreeNode root, int p, int q){
        if(covers(root.left, p)&&covers(root.left, q)) return commonAncestor(root.left, p, q);
        if(covers(root.right, p)&&covers(root.right, q)) return commonAncestor(root.right, p, q);
        System.out.println("We found the common ancestor of " + p + " and " + q + " is " + root.val);
        return root;
    }

    private static boolean covers(BinaryTreeNode node, int target) {
        return node != null && (node.val == target || covers(node.left, target) || covers(node.right, target));
    }

    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see.
     * Could be solve both by DFS and BFS
     */
    public static List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        if(root==null) return nodes;
        nodes.add(root.val);
        dfs(root, nodes, 0);
        Helper.printArrayList("The rightmost nodes on each level are", nodes);
        return nodes;
    }
    private static void dfs(BinaryTreeNode n, List<Integer> nodes, int level) {
        if(n==null) return;
        dfs(n.left, nodes, level+1);
        if(level >= nodes.size())
            nodes.add(n.val);
        else
            nodes.set(level, n.val);
        dfs(n.right, nodes, level+1);
    }

}
