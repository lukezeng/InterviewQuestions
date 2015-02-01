package com.company.algorithms;

import com.company.dataStructures.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class SearchingAlgorithm {
    public static int binarySearch(int[] input, int target){
        //pre: the input array is sorted
        if(target < input[0] || target > input[input.length-1]) {
            System.out.println("We cannot found " + target + " in array");
            return -1;
        }
        int left = 0, right = input.length;
        int mid = (left+right)/2;
        while(input[mid] != target){
            if(target > input[mid]){
                left = mid;
            } else {
                right = mid;
            }
            mid = (left+right)/2;
        }
        System.out.println("We found " + target + " at " + mid + " position in array");
        return mid;
    }

    public static boolean breathFirstSearch(BinaryTreeNode root, int target){
        if(root == null) return false;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        System.out.print("Searching: ");
        while(!queue.isEmpty()){
            BinaryTreeNode curr = queue.remove();
            System.out.print(curr.val + ", ");
            if(curr.val == target){
                System.out.print("Found " + target);
                return true;
            } else {
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right!= null) queue.add(curr.right);
            }
        }
        System.out.print(" End of Search. Cannot Find " + target);
        return false;
    }


    public static boolean depthFirstSearch(BinaryTreeNode root, int target){
        if(root == null) return false;
        Deque<BinaryTreeNode> deque = new LinkedList<BinaryTreeNode>();
        deque.push(root);
        System.out.print("Searching: ");
        while(!deque.isEmpty()){
            BinaryTreeNode curr = deque.pop();
            System.out.print(curr.val + ", ");
            if(curr.val == target){
                System.out.print("Found " + target);
                return true;
            } else {
                if(curr.left!= null) deque.push(curr.left);
                if(curr.right!= null) deque.push(curr.right);
            }
        }
        System.out.print(" End of Search. Cannot Find " + target);
        return false;
    }
}
