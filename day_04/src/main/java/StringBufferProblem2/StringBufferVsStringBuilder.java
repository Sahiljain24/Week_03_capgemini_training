package StringBufferProblem2;

public class StringBufferVsStringBuilder {

    // Method to measure time taken by StringBuffer
    public static long measureStringBufferTime(int iterations) {
        StringBuffer stringBuffer = new StringBuffer();
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method to measure time taken by StringBuilder
    public static long measureStringBuilderTime(int iterations) {
        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int iterations = 1_000_000;

        // Measuring time for StringBuffer
        long stringBufferTime = measureStringBufferTime(iterations);
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " ns");

        // Measuring time for StringBuilder
        long stringBuilderTime = measureStringBuilderTime(iterations);
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " ns");
    }
}

