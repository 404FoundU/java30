package DSA.Arrays;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] timeline = new int[1001]; // Max range for locations (0 to 1000)

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            timeline[from] += numPassengers; // Add passengers at the pickup point
            timeline[to] -= numPassengers;  // Remove passengers at the drop-off point
        }

        int currentPassengers = 0;
        for (int passengers : timeline) {
            currentPassengers += passengers;
            if (currentPassengers > capacity) {
                return false; // Capacity exceeded
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CarPooling solver = new CarPooling();
        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 4;

        System.out.println("Can carpool: " + solver.carPooling(trips, capacity)); // Output: false
    }
}

