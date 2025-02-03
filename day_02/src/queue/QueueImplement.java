package src.com.problems.queue;
import java.util.*;

public class QueueImplement {
    static int size=0;
    class Queue{
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public void addData(int data){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        ++size;   
        st1.push(data);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    public int removeData(){
        if(st1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        size--;
        return st1.pop();
    }

}
   public static void main(String[] args) {
        QueueImplement obj = new QueueImplement();
        Queue q = obj.new Queue();
        // int s = size;
        q.addData(1);
        q.addData(2);
        q.addData(3);
        q.addData(12);
        q.removeData();
        q.addData(4);
        q.addData(5);
        q.removeData();
        // System.out.println(q.removeData());
        // System.out.println(q.removeData());
        // System.out.println(q.removeData());
        // System.out.println(q.removeData());
        System.out.println(size);
        while(size>0){
            System.out.println(q.removeData());
            // size--;
        }
   }
}
