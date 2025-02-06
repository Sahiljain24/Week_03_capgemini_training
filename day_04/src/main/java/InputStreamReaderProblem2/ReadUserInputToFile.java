package InputStreamReaderProblem2;

import java.io.*;

public class ReadUserInputToFile {

    public static void readUserInputAndWriteToFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (!(line = reader.readLine()).equals("exit")) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readUserInputAndWriteToFile("output.txt");
    }
}
