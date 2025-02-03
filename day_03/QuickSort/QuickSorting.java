package QuickSort;

import java.util.Scanner;

public class QuickSorting {
    public static int partition(int arr[], int start, int end) {
        int piv = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[i] <= piv && i <= end - 1) {
                i++;
            }
            while (arr[j] > piv && j >= start + 1) {
                j--;
            }
        }
        if (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;
        return j;

    }

    private static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int par = partition(arr, start, end);
            quickSort(arr, start, par - 1);
            quickSort(arr, par + 1, end);
        }
    }

    public static void printArr(int arr[]) {
        for (int ii : arr) {
            System.out.print(ii + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            arr[i] = ele;
        }
        quickSort(arr, 0, n - 1);
        printArr(arr);
        sc.close();
    }
}