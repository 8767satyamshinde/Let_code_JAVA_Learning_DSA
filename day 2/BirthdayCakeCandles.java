import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int height : candles) {
            if (height > max) {
                max = height;
                count = 1;
            } else if (height == max) {
                count++;
            }
        }

        return count;
    }
}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // First line: number of candles
        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        // Second line: heights of candles (handles extra spaces)
        String[] candlesTemp = bufferedReader.readLine().trim().split("\\s+");

        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < candlesCount; i++) {
            int candlesItem = Integer.parseInt(candlesTemp[i]);
            candles.add(candlesItem);
        }

        int result = Result.birthdayCakeCandles(candles);
        System.out.println(result); // Print the result

        bufferedReader.close();
    } // 👈 This was missing
} // 👈 This was also missing
