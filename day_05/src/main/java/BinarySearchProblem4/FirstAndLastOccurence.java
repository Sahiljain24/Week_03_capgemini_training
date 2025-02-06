package BinarySearchProblem4;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {

        // Find the first and last occurrence of the target
        int first = findFirst(nums, target);

        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    //Find the first occurrence of the target
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    //Find the last occurrence of the target
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        FirstAndLastOccurence sol = new FirstAndLastOccurence();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = sol.searchRange(nums, target);

        // Print the first and last occurrence of the target
        System.out.println("First occurrence: " + result[0] + ", Last occurrence: " + result[1]);
    }
}


