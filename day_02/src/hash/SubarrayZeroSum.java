package src.com.problems.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Pair{
    int start;
    int end;
    Pair(int start, int end){
        this.start=start;
        this.end=end;
    }
}
public class SubarrayZeroSum {
    private static ArrayList<Pair> sumWithZero(int arr[]){
        ArrayList<Pair>ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int n=arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum==0){
                ans.add(new Pair(0, i));
            }
            ArrayList<Integer> temp = new ArrayList<>();
            if(hm.containsKey(sum)){
                temp=hm.get(sum);
                for(int ti=0; ti<temp.size(); ti++){
                    ans.add(new Pair(temp.get(ti)+1, i));
                }
            }
            hm.put(sum, temp);
            temp.add(i);

        }
        return ans;
    }
    public static void printSubarrayZeroSum(ArrayList<Pair>al, int arr[]){
        System.out.println("---- Subarrays with 0 sum -----");
        for(Pair itp : al){
            int st=itp.start;
            int ed=itp.end;
            for(int i=st; i<=ed; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("------- ending ------");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n ;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Pair> p=sumWithZero(arr);
        printSubarrayZeroSum(p,arr);
        sc.close();
    }
}
