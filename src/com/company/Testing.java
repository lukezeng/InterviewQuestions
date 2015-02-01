package com.company;

/**
 * Created by Luke on 1/31/2015.
 *
 */
public class Testing {
    public static void testingSortingAlgorithms(){
        System.out.println("--------------------------------- Sorting Algorithm---------------------------------------");
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
        System.out.println();
    }

    public static void testingSearchingAlgorithms(){
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
        System.out.println();
    }

    public static void MathInterviewQuestions(){
        System.out.println("--------------------------------- Math Interview Questions---------------------------------------");
        MathInterviewQuestions.squareRoot(9);
        MathInterviewQuestions.squareRoot(0.5);
        System.out.println("2 to the 3rd power is : " + MathInterviewQuestions.pow(2, 3));
        System.out.println("2 to the 4th power is : " + MathInterviewQuestions.pow(2, 4));
        System.out.println("2 to the 10th power is : " + MathInterviewQuestions.pow(2, 10));
        System.out.println();
    }

    public static void LinkedListInterviewQuestions(){
        System.out.println("--------------------------------- LinkedList Interview Questions---------------------------------------");
        Helper.printLinkedList(Setup.getLinkedList());
        Helper.printLinkedList(LinkedListInterviewQuestions.reversLinkedList(Setup.getLinkedList()));
        Helper.printLinkedList(LinkedListInterviewQuestions.reverseLinkedListR(Setup.getLinkedList()));
        LinkedListInterviewQuestions.isLoopedLinkedList(Setup.getLinkedList());
        LinkedListInterviewQuestions.isLoopedLinkedList(Setup.getLoopedLinkedList());
        System.out.println();
    }

    public static void testingRecursiveAlgorithm(){
        System.out.println("--------------------------------- Tree Interview Questions---------------------------------------");
        System.out.println("Given binary search tree, validateBinarySearchTree is returning: " + TreeInterviewQuestions.validateBinarySearchTree(Setup.getBinarySearchTree()));
        System.out.println("Given random binary tree, validateBinarySearchTree is returning: " + TreeInterviewQuestions.validateBinarySearchTree(Setup.getRandomBinaryTree()));
        System.out.print("Given preOrderTravers a binary search tree: ");
        TreeInterviewQuestions.preOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        System.out.print("Given inOrderTravers a binary search tree: ");
        TreeInterviewQuestions.inOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        System.out.print("Given postOrderTravers a binary search tree: ");
        TreeInterviewQuestions.postOrderTraverse(Setup.getBinarySearchTree());
        System.out.println();
        System.out.println();
    }

    public static void testingDynamicProgramming(){
        System.out.println("--------------------------------- Dynamic Programming Interview Questions---------------------------------------");
        DynamicProgramming.totalPossibleWays(10);
        DynamicProgramming.totalPossibleWays(20);
        DynamicProgramming.buySellStock(Setup.getRandomArray());
        DynamicProgramming.buySellStock(Setup.getSortedArray());
        System.out.println();
    }
}
