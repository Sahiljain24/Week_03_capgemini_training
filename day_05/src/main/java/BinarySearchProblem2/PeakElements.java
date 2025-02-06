package BinarySearchProblem2;
import java.util.Scanner;

public class PeakElements {

    // Function to find the peak element in the array
    public static int peakElement(int arr[]) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // Check if mid element is greater than its neighbors
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // If the left neighbor is greater, move left
            else if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, move right
            else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        // Finding and printing the peak element index
        System.out.println(peakElement(arr));

        // Printing the peak element and its index
        System.out.println("Peak element is at index: " + peakElement(arr) + " with value: " + arr[peakElement(arr)]);
    }
}
