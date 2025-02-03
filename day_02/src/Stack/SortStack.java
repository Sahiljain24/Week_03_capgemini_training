package src.com.problems.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SortStack {
    public static void insertStack(Stack<Integer>st, int ele){
            if(st.isEmpty() || ele<st.peek()){
                st.push(ele);
                return ;
            }
            int top=st.pop();
            insertStack(st, ele);
            st.push(top);
        }
        public static void sortStack(Stack<Integer>st){
                if(st.isEmpty()){
                    return;
                }
                int top=st.pop();
                sortStack(st);
                insertStack(st, top);
        }
        public static void main(String[] args) throws Exception {
            Stack<Integer> st = new Stack<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                st.push(Integer.parseInt(br.readLine()));
            }
            sortStack(st);
            while(!st.isEmpty()){
            System.out.println(st.pop()+" ");
        }

    }
}
