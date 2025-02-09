package ProblemStatement5;

public class FibbonaciSeries {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n){
        int a = 0, b = 1, sum;
        for(int i = 2; i <= n;i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Test cases

        for (int n : testCases) {
            System.out.println("Fibonacci for N = " + n);

            // Measure Recursive Fibonacci Time
            long startRecursive = System.nanoTime();
            int resultRecursive = fibonacciRecursive(n);
            long endRecursive = System.nanoTime();
            long timeRecursive = (endRecursive - startRecursive) / 1_000_000; // Convert to ms

            // Measure Iterative Fibonacci Time
            long startIterative = System.nanoTime();
            int resultIterative = fibonacciIterative(n);
            long endIterative = System.nanoTime();
            long timeIterative = (endIterative - startIterative) / 1_000_000; // Convert to ms

            // Print Results
            System.out.println("Recursive Result: " + resultRecursive + " | Time: " + timeRecursive + " ms");
            System.out.println("Iterative Result: " + resultIterative + " | Time: " + timeIterative + " ms");
            System.out.println("---------------------------");

            // Stop recursive test if N is too large (prevents infinite execution)
            if (timeRecursive > 10000) {
                System.out.println("Recursive method is too slow for N = " + n + ". Skipping further tests.");
                break;
            }
        }
    }


}

















