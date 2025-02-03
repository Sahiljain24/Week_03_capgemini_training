package CountSort;

import java.util.Scanner;

public class CountingSorting {
    public static void countingSort(int arr[]){
        int n=arr.length;
        int mx=arr[0];
        for(int ii : arr){
            if(mx<ii)mx=ii;
        }
        int cnt[]=new int[mx+1];
        int temp[]=new int[n+1];
        for(int i=0; i<n; i++){
            cnt[arr[i]]++;
        }
        for(int i=1; i<=mx; i++){
            cnt[i]+=cnt[i-1];
        }
        for(int i=n-1; i>=0; i--){
            temp[cnt[arr[i]]-1]=arr[i];
            cnt[arr[i]]--;
        }
        // Arrays.fill(arr, 0);
        for(int i=0; i<n; i++){
            arr[i]=temp[i];
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
        countingSort(arr);
        printArr(arr);
        sc.close();
    }
}
