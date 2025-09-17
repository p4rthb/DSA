import java.util.*;

/*
    Category = Arrays
    Difficulty = Medium

    Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be ordered in ascending order with respect to the numbers they hold.
    If no three numbers sum up to the target sum, the function should return an empty array.

    Sample Input
    array = [12, 3, 1, 2, -6, 5, -8, 6]
    targetSum = 0

    Sample Output
    [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
*/

public class ThreeNumberSum {

    public static void main(String[] args) {
        List<Integer[]> pairOfNums = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        pairOfNums.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        int left;
        int right;
        List<Integer[]> intArrList = new LinkedList<>();

        for(int i=0; i<array.length-2; i++){
            left = i+1;
            right = array.length-1;
            do{
                if(array[i]+array[left]+array[right] < targetSum)
                    left++;
                else if(array[i]+array[left]+array[right] > targetSum)
                    right--;
                else{
                    Integer[] intArr = new Integer[3];
                    intArr[0] = array[i];
                    intArr[1] = array[left];
                    intArr[2] = array[right];
                    intArrList.add(intArr);
                    left++;
                    right--;
                }
            }while(left<right);
        }

        return intArrList;
    }
}
