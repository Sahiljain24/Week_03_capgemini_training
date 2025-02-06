package StringBuilderProblem1;

public class ReverseString {
    public static void main(String[] args) {
        //Create a String variable name string
        String string = "Hello String";

        //Create a StringBuilder
        StringBuilder stringbuilder = new StringBuilder(string);

        //Reverse StringBuilder by inBuilt method
        stringbuilder.reverse();

        //Display the result
        System.out.println(stringbuilder);

    }
}
