import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String result = "";
        if (s.substring(0, 2).equals("12")) {
            if (s.substring(s.length() - 2).equalsIgnoreCase("AM")) {
                result = "00" + s.substring(2, s.length() - 2);
            } else if (s.substring(s.length() - 2).equalsIgnoreCase("PM")) {
                result = "12" + s.substring(2, s.length() - 2);
            }
        } else {
            if (s.substring(s.length() - 2).equalsIgnoreCase("AM")) {
                result = s.substring(0, s.length() - 2);
            } else if (s.substring(s.length() - 2).equalsIgnoreCase("PM")) {
                Integer convertedHour = new Integer(Integer.parseInt(s.substring(0, 2)) + 12);
                result = convertedHour.toString() + s.substring(2, s.length() - 2);
            }
        }
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
