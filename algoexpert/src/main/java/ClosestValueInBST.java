/*
    Category = BST
    Difficulty = Easy

    Find Closest Value In BST
    Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns
    the closest value to that target value contained in the BST.
    You can assume that there will only be one closest value.
    Each BST node has an integer
    value, a left child node, and a right child
    node. A node is said to be a valid Bst node if and only if it satisfies the BST property: its value
    is strictly greater than the values of every node to its left; its value is less than or equal to
    the values of every node to its right; and its children nodes are either valid BST nodes themselves
    or None / null.

    Sample Input
    tree =  10
           /   \
          5    15
        /  \  /  \
       2    5 13  22
      /        \
     1          14
    target = 12

    Sample Output
    13

    Reference - https://www.algoexpert.io/questions/find-closest-value-in-bst
 */

public class ClosestValueInBST {

    public static void main(String[] args) {
        //TODO: Define a test input tree and call the findClosestValueInBst method using that
    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int minDistance = Integer.MAX_VALUE;
        int currentNodeDist = 0;
        int currentMinNode = 0;

        return findClosestValue(tree, target, minDistance,
                currentNodeDist, currentMinNode);

    }

    private static int findClosestValue(BST tree, int target, int minDistance,
                                        int currentNodeDist, int currentMinNode){
        if(tree == null)
            return currentMinNode;

        currentNodeDist = Math.abs(tree.value-target);

        if(currentNodeDist < minDistance){
            minDistance = currentNodeDist;
            currentMinNode = tree.value;
        }

        if(target == tree.value)
            return tree.value;
        else if(target < tree.value){
            return findClosestValue(tree.left, target, minDistance,
                    currentNodeDist, currentMinNode);
        }else{
            return findClosestValue(tree.right, target, minDistance,
                    currentNodeDist, currentMinNode);
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
