package DSA.Patterns.Heaps;


import java.util.PriorityQueue;

/*
You have
𝑛
n chocolates with weights given in an array weights[n], where weights[i] represents the weight of the
𝑖
i-th chocolate. Each day, you can pick one chocolate, consume half of its weight (calculated as ceil(weights[i] / 2)), and keep the remaining portion.

Calculate the minimum possible total weight of the chocolates after
𝑑
d days. Note that you can eat from the same chocolate multiple times.

Input Format:
The first line contains an integer
𝑛
n, denoting the number of elements in weights.
The next
𝑛
n lines each contain an integer describing weights[i].
The last line contains an integer
𝑑
d, denoting the number of days.
Output Format:
A single integer: the minimum total weight of the chocolates after
𝑑
d days.
Example Input 1:
Copy code
2
2
3
2
Example Output 1:
Copy code
3
Explanation:

Day 1: Consume chocolate with weight 3 → Remaining weight = ceil(3 / 2) = 2.
Day 2: Consume chocolate with weight 2 → Remaining weight = ceil(2 / 2) = 1.
Remaining chocolates are: [2, 1].
Total weight after 2 days =
2
+
1
=
3
2+1=3.
 */
public class MinimumTotalWeight2 {

    // Function to calculate the minimum total weight after d days
    public static int findMinWeight(int[] weights, int d) {
        if (weights.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int weight : weights) {
            pq.add(weight);
        }
        for (int i = 0; i < d; i++) {
            int maxWeight = pq.poll();
            int newWeight = (int) Math.ceil(maxWeight / 2.0);
            pq.add(newWeight);
        }
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            totalWeight += pq.poll();
        }
        return totalWeight;
    }

    // Main method to handle custom input format
    public static void main(String[] args) {


        // Read the number of moves (d)
        int[] weights = new int[]{2, 3};

        // Call the function and print the result
        System.out.println(findMinWeight(weights, 1));

    }
}
