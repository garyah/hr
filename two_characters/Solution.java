import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int alternate(String s) {
        // f[] - for letters of alphabet, true if found in s, false otherwise
        boolean[] f = new boolean['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a'] = true;
        }
        // maxLen - length of longest string with just two alternating characters,
        //  return value
        int maxLen = 0;
        for (int j = 0; j < f.length; j++) {
            for (int k = j + 1; k < f.length; k++) {
                if (f[j] && f[k]) {
                    // System.out.print((char)('a' + j));
                    // System.out.print(", ");
                    // System.out.print((char)('a' + k));
                    // System.out.println();
                    // if valid combination of letters to leave in string
                    // c0 = last character seen, use sentinel
                    char c0 = '0';
                    // len = length of valid string for this combination
                    int len = 0;
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c != (char)('a' + j) && c != (char)('a' + k)) continue; // letter to remove
                        if (c == c0) {
                            len = 0;
                            break;
                        }
                        c0 = c;
                        len++;
                    }
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
