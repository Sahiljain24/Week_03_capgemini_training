package src.com.problems.hash;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    private static int solution(int arr[]){
       int ans=0,cnt=1;
       HashSet<Integer>hs=new HashSet<>();
       for(int ii : arr){hs.add(ii);}
       for(int ii : arr){
        if(!hs.contains(ii-1)){
                cnt=1;
            int ele=ii;
            while(hs.contains(ele+1)){
                cnt++;
                ele++;
            }
        }
        ans=Math.max(ans,cnt);
    }
    return ans;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(solution(arr));
        sc.close();
    }
}
