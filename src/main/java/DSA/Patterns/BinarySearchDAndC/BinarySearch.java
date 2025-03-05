package DSA.Patterns.BinarySearchDAndC;

//https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int[] intArr = new int[] {1, 3, 4, 5,6,9,14,20,30,100};

        System.out.println(test.testMethod(intArr, 9));

    }

    //binary search on Answer
    private int testMethod(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid; // Narrow the search range to the left
            } else {
                left = mid + 1; // Narrow the search range to the right
            }
        }

        return left; // `left` points to the correct index for insertion
    }



}
