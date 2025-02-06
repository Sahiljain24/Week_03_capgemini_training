package StringBuilderProblem2;

import java.util.HashSet;

public class RemovesDuplicates {

    // Method to remove duplicate characters from a string
    public static String removeDuplicates(String str) {

        // Create a StringBuilder to build the new string with no duplicates
        StringBuilder sb = new StringBuilder();

        // Create a HashSet to track the characters
        HashSet<Character> hst = new HashSet<>();

        // Convert the string to a character array and iterate through it
        for (char ch : str.toCharArray()) {

            if (!hst.contains(ch)) {
                hst.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Main method to test the removeDuplicates function
    public static void main(String[] args) {
        String str = "Helloo";

        // Call removeDuplicates method to remove duplicate characters
        String result = removeDuplicates(str);

        // Print the result after removing duplicates
        System.out.println(result);
    }
}