package DSA.Patterns.Heaps;


import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "ᵗʰ largest element is " + result);

    }

    private int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();


    }


}
