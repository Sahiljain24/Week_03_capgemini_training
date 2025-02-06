package BinarySearchProblem1;

public class RotatedSortedArray {

    // Function to find the rotation point (index of the smallest element)
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid;

        // Binary search loop to find the smallest element
        while (left < right) {
            mid = (left + right) / 2;

            // If mid element is greater than the rightmost element,

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int rotationPointIndex = findRotationPoint(arr);

        // Print the rotation point index and the smallest element
        System.out.println("Rotation point index: " + rotationPointIndex);
        System.out.println("Smallest element: " + arr[rotationPointIndex]);
    }
}
