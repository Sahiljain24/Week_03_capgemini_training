package BinarySearchProblem3;

public class TargetValueInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Check if the matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        //Binary search values
        int left = 0, right = rows * cols - 1;

        while (left <= right) {

            // Calculate the middle index
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            // If mid element is the target, return true
            if (midElement == target) {
                return true;

                // If target is greater, search in the right half
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TargetValueInMatrix sol = new TargetValueInMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(sol.searchMatrix(matrix, target));
    }
}

