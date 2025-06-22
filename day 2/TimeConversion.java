import java.io.*;

class Result {

    public static String timeConversion(String s) {
        String amPm = s.substring(8); // "AM" or "PM"
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8); // ":MM:SS"

        if (amPm.equals("AM")) {
            if (hour == 12) hour = 0;
        } else {
            if (hour != 12) hour += 12;
        }

        return String.format("%02d%s", hour, rest);
    }
}

public class TimeConversion { // ✅ CLASS NAME FIXED
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Optional: Use this for file output if needed
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        System.out.print("Enter time (e.g., 07:05:45PM): ");
        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);
        System.out.println("24-hour format: " + result);

        bufferedReader.close();

        // Optional: Write to file
        // bufferedWriter.write(result);
        // bufferedWriter.newLine();
        // bufferedWriter.close();
    }
}
