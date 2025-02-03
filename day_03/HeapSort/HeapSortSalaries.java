import java.util.Arrays;

public class HeapSortSalaries {
    // Heapify a subtree rooted at index i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and heapify
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Heap Sort function
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 60000, 45000, 80000};

        System.out.println("Before Sorting: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("After Sorting: " + Arrays.toString(salaryDemands));
    }
