package InsertionSort;

public class InsertionSorting {
    public static void sortEmployeeId(int arr[]){
        int temp;
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int arr[] = {101,110,104,103,113,111};
        System.out.println("Array Before Sort");
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sortEmployeeId(arr);
        System.out.println("Array After Sort");
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
