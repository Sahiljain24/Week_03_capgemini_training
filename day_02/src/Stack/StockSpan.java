/*
 * Stock Span Problem
Problem: For each day in a stock price array, calculate the span (number of consecutive days the price was 
less than or equal to the current day's price).
Hint: Use a stack to keep track of indices of prices in descending order.

 */
package src.com.problems.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {
    // function for solution 
    public static int[] solution(int arr[]){
           int ans[]=new int[arr.length];
           Stack<Integer> st = new Stack<>();
           for(int i=0; i<arr.length; i++){
               while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                 st.pop();
               }
               if(st.isEmpty()){
                   ans[i]=i+1;
               }else{
                   ans[i]=i-st.peek();
               }
               st.push(i);
           }
           return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int ans[]=solution(arr);
        for(int ii : ans){
            System.out.print(ii+" ");
        }
        System.out.println();
    }
}
