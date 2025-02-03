package src.com.problems.queue;
import java.util.Scanner;

public class CircularDistance {
    public static int solution(int dis[], int pet[], int n){
        // int ans=0;
        int current=0;
        int total=0;
        int start=0; 
        for(int i=0;i<pet.length;i++){
            current+=pet[i]-dis[i];
            total+=pet[i]-dis[i]; 
            if(current<0){
                current=0;
                start=i+1;
            }
        } 
      return total<0 ? -1 : start;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int dis[]=new int[n];
        int pet[]=new int[n];
        for(int i=0; i<n ;i++){
            dis[i]=sc.nextInt();
        }
        for(int i=0; i<n ;i++){
            pet[i]=sc.nextInt();
        }
      
        int ans=solution(dis, pet, n);
        
        System.out.println(ans);
        sc.close();
    }
}
