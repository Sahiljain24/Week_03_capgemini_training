package LinearSearchProblem2;
import java.util.Scanner;

class SpecificWordList {

    // Function to search for a specific word in an array of sentences
    public static String searchWordInSentences(String[] sentences, String word) {
        for (String sentence : sentences) {

            // Check if the sentence contains the specific word
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        // Array of sentences
        String[] sentences = {
                "Java is a popular programming language.",
        };

        // Word to search for
        String word = "Java";

        // Call the function and print the result
        System.out.println("Sentence containing the word: " + searchWordInSentences(sentences, word));
    }
}










