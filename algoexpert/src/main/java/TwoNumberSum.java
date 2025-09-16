import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Category = Arrays
    Difficulty = Easy

    Write a function that takes in a non-empty array of distinct integers and an
    integer representing a target sum. If any two numbers in the input array sum
    up to the target sum, the function should return them in an array, in any
    order. If no two numbers sum up to the target sum, the function should return
    an empty array.

    Note that the target sum has to be obtained by summing two different integers
    in the array; you can't add a single integer to itself in order to obtain the
    target sum.

    You can assume that there will be at most one pair of numbers summing up to
    the target sum.

    Sample Input :
    array = [3, 5, -4, 8, 11, 1, -1, 6]
    target = 10

    Sample Output :
    [-1, 11]
 */

public class TwoNumberSum {

    public static void main(String args[]) {
        int[] pairOfNums = getNumPair_solution1(new int[]{3,5,-1,8,11,1,-1,6}, 10);
//        int[] pairOfNums = getNumPair_solution2(new int[]{3,5,-1,8,11,1,-1,6}, 10);

        System.out.println(Arrays.toString(pairOfNums));
    }

    public static int[] getNumPair_solution1(int[] array, int targetSum) {
        // Write your code here.
        int arrLen = array.length;

        for(int i=0; i<arrLen-1; i++){
            for(int j=i+1; j<arrLen; j++){
                if(array[i]+array[j]==targetSum){
                    return new int[]{array[i], array[j]};
                }
            }
        }

        return new int[0];
    }

    public static int[] getNumPair_solution2(int[] array, int targetSum) {
        // Write your code here.
        Set<Integer> visited = new HashSet<>();

        for(int i: array){
            if(visited.contains(targetSum-i))
                return new int[]{targetSum-i, i};
            else
                visited.add(i);
        }

        return new int[0];
    }
}


