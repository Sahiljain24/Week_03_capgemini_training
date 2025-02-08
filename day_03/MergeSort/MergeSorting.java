package MergeSort;

import java.util.Scanner;

public class MergeSorting {


    public static void mergeSort(int arr[], int start, int end){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start, end, mid);
        }
    }

    public static void merge(int arr[], int start, int end, int mid){
        int n1=mid-start+1;
        int n2=end-mid;
        int idx=start;

        int la[]=new int[n1];
        int ra[]=new int[n2];

        for(int i=0; i<n1; i++){
            la[i]=arr[start+i];
            // System.out.println(la[i]+"lll ");
        }

        for(int i=0; i<n2; i++){
            ra[i]=arr[mid+i+1];
            // System.out.println(ra[i]+"rrr ");
        }
        // System.out.println("-----------------------------");
        int itl=0,itr=0;
        while(itl<n1 && itr<n2){
            if(la[itl]>ra[itr]){
                arr[idx]=ra[itr];
                itr++;
            }else{
                arr[idx]=la[itl];
                itl++;
            }
            // System.out.print(arr[idx]+"  ");
            idx++;
        }

        while(itl<n1){
            arr[idx]=la[itl];
            // System.out.print(arr[idx]+"  ");

            itl++;
            idx++;
        }

        while(itr<n2){
            arr[idx]=ra[itr];
            // System.out.print(arr[idx]+"  ");

            itr++;
            idx++;
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
        mergeSort(arr,0,n-1);
        printArr(arr);
        sc.close();
    }
}