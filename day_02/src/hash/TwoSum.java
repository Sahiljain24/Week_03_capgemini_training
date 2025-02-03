package src.com.problems.hash;

import java.util.HashMap;
import java.util.Scanner;
public class TwoSum {
  
    private static int[] twoSum(int[] nums, int target) {
     int n=nums.length;
     HashMap<Integer,Integer>mp=new HashMap<>();
     int ans[]=new int[2];
     for(int i=0;i<n;i++){
         if(mp.containsKey(target-nums[i])){
             ans[1]=i;
             ans[0]=mp.get(target-nums[i]);
             return ans;

         }
        mp.put(nums[i],i);
     }
     return ans;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ;i++){
            arr[i]=sc.nextInt();
        }
        int ans[]=twoSum(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
        sc.close();
    }
}
    
