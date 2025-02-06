package StringBufferProblem1;

public class StringBufferConcatenation {

    // Method to concatenate an array of strings using StringBuffer
    public static String concatenateStrings(String[] strings) {
        // Using StringBuffer for efficient string concatenation
        StringBuffer result = new StringBuffer();

        // Iterating through the array and appending each string
        for (String str : strings) {
            result.append(str);
        }

        // Converting StringBuffer to String and returning the result
        return result.toString();
    }

    public static void main(String[] args) {

        String[] words = {"Hello", " ", "World", "!"};

        // Calling the method and printing the result
        String concatenatedString = concatenateStrings(words);
        System.out.println("Concatenated String: " + concatenatedString);
    }
}
