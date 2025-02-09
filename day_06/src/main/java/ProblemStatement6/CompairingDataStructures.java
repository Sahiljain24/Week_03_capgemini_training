package ProblemStatement6;

import java.util.*;

public class CompairingDataStructures {

    // Linear Search (Array)
    public static boolean linearSearch(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) return true;
        }
        return false;
    }

    // Search in HashSet (O(1) on average)
    public static boolean hashSetSearch(HashSet<Integer> set, int key) {
        return set.contains(key);
    }

    // Search in TreeSet (O(log N))
    public static boolean treeSetSearch(TreeSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static void timeTakeForSearching(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Populate data structures
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100000);
            hashSet.add(array[i]);
            treeSet.add(array[i]);
        }

        int key = rand.nextInt(100000);

        long startTime, endTime;

        // Linear Search in Array
        try {
            startTime = System.nanoTime();
            boolean foundArray = linearSearch(array, key);
            endTime = System.nanoTime();
            long arrayTime = endTime - startTime;
            double arrayTimeMs = arrayTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
            System.out.println("Array search time for N=" + n + ": " + arrayTimeMs + " milliseconds");
            System.out.println("Found in Array: " + foundArray);
        } catch (Exception e) {
            System.err.println("Error with Array search: " + e.getMessage());
        }

        // HashSet Search
        try {
            startTime = System.nanoTime();
            boolean foundHashSet = hashSetSearch(hashSet, key);
            endTime = System.nanoTime();
            long hashSetTime = endTime - startTime;
            double hashSetTimeMs = hashSetTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
            System.out.println("HashSet search time for N=" + n + ": " + hashSetTimeMs + " milliseconds");
            System.out.println("Found in HashSet: " + foundHashSet);
        } catch (Exception e) {
            System.err.println("Error with HashSet search: " + e.getMessage());
        }

        // TreeSet Search
        try {
            startTime = System.nanoTime();
            boolean foundTreeSet = treeSetSearch(treeSet, key);
            endTime = System.nanoTime();
            long treeSetTime = endTime - startTime;
            double treeSetTimeMs = treeSetTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
            System.out.println("TreeSet search time for N=" + n + ": " + treeSetTimeMs + " milliseconds");
            System.out.println("Found in TreeSet: " + foundTreeSet);
        } catch (Exception e) {
            System.err.println("Error with TreeSet search: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Running Search comparison for different dataset sizes
        int[] sizes = {1000, 100000, 1000000};

        for (int n : sizes) {
            System.out.println("Comparing search time for N = " + n);
            timeTakeForSearching(n);
            System.out.println("---------------------------------------------------------");
        }
    }
}