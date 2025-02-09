package ProblemStatement1;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static java.util.Arrays.binarySearch;

public class SearchATarget {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};  // Dataset sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] dataset = new int[size];

            // Generate random numbers in dataset
            for (int i = 0; i < size; i++) {
                dataset[i] = rand.nextInt(size * 10);  // Random numbers
            }

            int target = dataset[rand.nextInt(size)];  // Pick a random target

            // Measure Linear Search time
            long startLinear = System.nanoTime();
            searching(dataset, target);
            long endLinear = System.nanoTime();
            long timeLinear = (endLinear - startLinear) / 1000000; // Convert to ms

            // Sort dataset for Binary Search
            Arrays.sort(dataset);

            // Measure Binary Search time
            long startBinary = System.nanoTime();
            binarySearch(dataset, target);
            long endBinary = System.nanoTime();
            long timeBinary = (endBinary - startBinary) / 1000000; // Convert to ms

            // Print Results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + timeLinear + " ms");
            System.out.println("Binary Search Time: " + timeBinary + " ms");
            System.out.println("--------------------------");
        }
    }
//    Scanner input = new Scanner(System.in);

//    int target = input.nextInt();


    public static int searching(int sizes[], int target) {
        int j = 0;
        //Linear Search
        for(int i = 0; i < sizes.length;i++){

        }
        return -1;
    }
    public static int searchinbinary(int sizes[], int target){
        int left = 0, right = sizes.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sizes[mid] == target) return mid;
            else if (sizes[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;

    }
}











