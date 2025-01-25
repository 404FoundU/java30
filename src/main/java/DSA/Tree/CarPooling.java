package DSA.Tree;
/*
You and your friends are driving to a Campground to go camping. Only two of you have cars, so you will be carpooling.

Routes to the campground are linear, so each location will only lead to one other location. There will be no loops or detours. Both cars will leave from their starting locations at the same time. The first car to pass someone's location will pick them up. If both cars arrive at the same time, the person can go in either car.

Input:

Roads: A list of roads represented as [Origin, Destination, Duration]. Each road specifies the origin, destination, and the duration it takes to drive between the two locations.
Starting Locations: A list of starting locations for the two cars.
People: A list of people and the locations where they live.
Output:

Return a collection of which car each person will join upon arriving at the campground.
Example 1:
Input:

roads1 = [
    ["Bridgewater", "Caledonia", 30],
    ["Caledonia", "New Grafton", 15],
    ["New Grafton", "Campground", 5],
    ["Liverpool", "Milton", 10],
    ["Milton", "New Grafton", 30]
]
starts1 = ["Bridgewater", "Liverpool"]
people1 = [
    ["Jessie", "Bridgewater"],
    ["Travis", "Caledonia"],
    ["Jeremy", "New Grafton"],
    ["Katie", "Liverpool"]
]
Output:

Car 1 Path (from Bridgewater): Bridgewater -> Caledonia -> New Grafton -> Campground
  Picks up: Jessie, Travis
Car 2 Path (from Liverpool): Liverpool -> Milton -> New Grafton -> Campground
  Picks up: Katie, Jeremy
Example 2:
Input:

roads2 = [
    ["Riverport", "Chester", 40],
    ["Chester", "Campground", 60],
    ["Halifax", "Chester", 40]
]
starts2 = ["Riverport", "Halifax"]
people2 = [
    ["Colin", "Riverport"],
    ["Sam", "Chester"],
    ["Alyssa", "Halifax"]
]
Output:

Car 1 Path (from Riverport): Riverport -> Chester -> Campground
  Picks up: Colin
Car 2 Path (from Halifax): Halifax -> Chester -> Campground
  Picks up: Alyssa, Sam
Assumptions:
Linear Routes: The routes are straightforward, with no cycles or loops.

Simultaneous Start: Both cars start at the same time.

Pickup Rules:

A person is picked up by the first car to reach their location.
If both cars arrive at the same time, the person can choose either car.
Output Requirements:

Indicate which people are in each car upon arrival at the campground.


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarPooling {

    public static Map<String, List<String>> assignPeopleToCars(
            List<String[]> roads, List<String> starts, List<String[]> people) {

        // Cost from src to dest Map
        Map<String, Integer> costCarA = calculateTravelTimes(starts.get(0), roads);
        Map<String, Integer> costCarB = calculateTravelTimes(starts.get(1), roads);

        // Assign people to cars
        Map<String, List<String>> result = new HashMap<>();
        result.put("Car 1", new ArrayList<>());
        result.put("Car 2", new ArrayList<>());

        for (String[] person : people) {
            String name = person[0];
            String location = person[1];

            // Integer .MAX VALUE. because car 2 will reach new Grafton before carA to pick jeremy
            int car1Time = costCarA.getOrDefault(location, Integer.MAX_VALUE);
            int car2Time = costCarB.getOrDefault(location, Integer.MAX_VALUE);

            if (car1Time <= car2Time) {
                result.get("Car 1").add(name);
            } else {
                result.get("Car 2").add(name);
            }
        }

        return result;
    }

    private static Map<String, Integer> calculateTravelTimes(String start, List<String[]> roads) {
        Map<String, Integer> times = new HashMap<>();
        int time = 0;
        String current = start;

        for (String[] road : roads) {
            if (road[0].equals(current)) {
                times.put(current, time);
                time += Integer.parseInt(road[2]);
                current = road[1];
            }
        }

        times.put(current, time); // Add final destination
        return times;
    }

    public static void main(String[] args) {
        // Example 1
        List<String[]> roads1 = Arrays.asList(
                new String[]{"Bridgewater", "Caledonia", "30"},
                new String[]{"Caledonia", "New Grafton", "15"},
                new String[]{"New Grafton", "Campground", "5"},
                new String[]{"Liverpool", "Milton", "10"},
                new String[]{"Milton", "New Grafton", "30"}
        );
        List<String> starts1 = Arrays.asList("Bridgewater", "Liverpool");
        List<String[]> people1 = Arrays.asList(
                new String[]{"Jessie", "Bridgewater"},
                new String[]{"Travis", "Caledonia"},
                new String[]{"Jeremy", "New Grafton"},
                new String[]{"Katie", "Liverpool"}
        );

        System.out.println("Example 1:");
        Map<String, List<String>> result1 = assignPeopleToCars(roads1, starts1, people1);
        System.out.println(result1);

        // Example 2
        List<String[]> roads2 = Arrays.asList(
                new String[]{"Riverport", "Chester", "40"},
                new String[]{"Chester", "Campground", "60"},
                new String[]{"Halifax", "Chester", "40"}
        );
        List<String> starts2 = Arrays.asList("Riverport", "Halifax");
        List<String[]> people2 = Arrays.asList(
                new String[]{"Colin", "Riverport"},
                new String[]{"Sam", "Chester"},
                new String[]{"Alyssa", "Halifax"}
        );

        System.out.println("Example 2:");
        Map<String, List<String>> result2 = assignPeopleToCars(roads2, starts2, people2);
        System.out.println(result2);
    }
}

