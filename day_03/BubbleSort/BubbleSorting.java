package BubbleSort;

public class BubbleSorting {
    public static void studentMarks(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {60,40,70,64,84,79};
        System.out.println("Array Before Sort");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        studentMarks(arr);

        System.out.println("Array After Sort");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
