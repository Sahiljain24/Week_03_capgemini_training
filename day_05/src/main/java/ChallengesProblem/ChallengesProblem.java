package ChallemgeProblem;
import java.util.Arrays;

public class ChallengesProblem {

    // Function to find the first missing positive integer
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //Mark numbers outside the range
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        //Mark visited numbers by making the corresponding index negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        //Find the first positive index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    //Binary search for a target number
    public int binarySearch(int[] nums, int target) {

        // Sort the array before binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ChallengesProblem sol = new ChallengesProblem();

        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + sol.firstMissingPositive(nums));

        int[] numsForSearch = {5, 2, 8, 1, 9, 3};
        int target = 8;
        System.out.println("Index of target: " + sol.binarySearch(numsForSearch, target));
    }
}
