package SelectionSort;

public class SelectionSorting {
    public static void examScores(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n ; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {67, 70, 91, 73, 97, 61};
        System.out.println("Marks Before Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        examScores(arr);
        System.out.println("Marks After Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}