package src.com.problems.hash;

import java.util.HashSet;
import java.util.Scanner;

public class TargetSum {
    private static boolean isPresentSum(int arr[], int target){
        HashSet<Integer> hs = new HashSet<>();
        for(int ii : arr){
            if(hs.contains(target-ii)){
                return true;
            }
            hs.add(ii);
        }
        return false;
    }
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(isPresentSum(arr, target) ? "yes pair is present with target" : "pair not present");
        sc.close();
    }
}
