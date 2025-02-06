package InputStreamReaderProblem1;

import java.io.*;

public class ConvertByteToCharStream {

    public static void readBinaryFile(String fileName, String charset) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "example.txt";
        readBinaryFile(fileName, "UTF-8");
    }
}
