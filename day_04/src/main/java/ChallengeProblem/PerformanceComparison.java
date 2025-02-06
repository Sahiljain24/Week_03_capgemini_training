package ChallengeProblem;

import java.io.*;

public class PerformanceComparison {

    public static void main(String[] args) throws IOException {
        // StringBuilder and StringBuffer Performance
        String[] words = new String[]{"hello"};
        int iterations = 1000000;

        // Test StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            for (String word : words) {
                sb.append(word);
            }
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");

        // Test StringBuffer
        startTime = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            for (String word : words) {
                sf.append(word);
            }
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");

        // FileReader and BufferedReader Performance
        String fileName = "largefileexample.txt"; // Specify your 100MB text file here
        long wordCount = countWordsUsingFileReader(fileName);
        System.out.println("Number of words in the file: " + wordCount);
    }

    // Method to count words in a file using FileReader and BufferedReader
    public static long countWordsUsingFileReader(String fileName) throws IOException {
        long wordCount = 0;

        // Create FileReader and BufferedReader objects
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            // Split the line into words based on whitespace and count them
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        br.close();
        return wordCount;
    }
}