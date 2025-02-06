package FileReaderProblem2;

import java.io.*;
public class WordCounter {

    public static int countWordOccurrences(String fileName, String targetWord) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";
        System.out.println("Word count: " + countWordOccurrences(fileName, "hello"));
    }
}
