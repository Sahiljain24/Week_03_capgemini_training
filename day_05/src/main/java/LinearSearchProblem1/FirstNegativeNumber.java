package LinearSearchProblem1;

import java.util.Scanner;

public class FirstNegativeNumber {

    // Method to perform linear search for the first negative number
    public static int linearSearch(int arr[]) {

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {

            // Check if the current element is negative
            if (arr[i] < 0) {

                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        // Create a scanner object to take user input
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        // Declare an array of size n
        int arr[] = new int[n];


        System.out.println("Elements of an Array");

        // Input the elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt(); // Store the entered number in the array
        }

        // Call the linearSearch method and print the result
        System.out.println(linearSearch(arr));
    }
}
