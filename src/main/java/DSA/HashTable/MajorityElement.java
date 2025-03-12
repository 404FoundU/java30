package DSA.HashTable;

//https://www.youtube.com/watch?v=c1B3LZQtZ_s
// Boyer Moore Voting for Majority
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        return element;

    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums3 = {3, 2, 1, 1, 2, 2, 2, 3, 2};

        System.out.println("Majority Element: " + majorityElement(nums1)); // Output: 3
        System.out.println("Majority Element: " + majorityElement(nums2)); // Output: 2
        System.out.println("Majority Element: " + majorityElement(nums3)); // Output: 2
    }
}
