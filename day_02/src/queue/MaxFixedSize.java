package src.com.problems.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxFixedSize {
    private static int[] solution(int arr[], int n, int k){
       int ans[]=new int[n-k+1];
       Deque<Integer> dq = new ArrayDeque<Integer>();
       for(int i=0; i<n; i++){
         while(!dq.isEmpty() && dq.peekFirst()<i-k+1){
            dq.pollFirst();
         }
         while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
            dq.pollLast();
         }
         dq.offerLast(i);
         if(i>=k-1){
            ans[i-k+1]=arr[dq.peekFirst()];
         }
       }
       return ans;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ;i++){
            arr[i]=sc.nextInt();
        }
        int ans[]=solution(arr, n, k);
        for(int ii : ans){
            System.out.print(ii+" ");
        }
        System.out.println();
        sc.close();
    }
}

