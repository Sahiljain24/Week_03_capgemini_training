package FileReaderProblem1;

import java.io.*;
public class ReadAFileLineByLine {

    public static void readFileLineByLine(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        String fileName = "example.txt";
        readFileLineByLine(fileName);
    }
}
