import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
import java.util.*;
// import java.util.concurrent.*;
// import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        // for stack items, use an array of characters, instead of string
        Stack<char[]> stack = new Stack<char[]>();
        for (int i = 0; i < s.length(); i++) {
            // retrieve next bracket
            char[] c_arr = new char[]{s.charAt(i)};
            char c = c_arr[0];

            // push all left brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c_arr);
                continue;
            }

            // ignore all non-bracket characters
            if (c != ')' && c != ']' && c != '}') {
                continue;
            }

            // process right brackets, rejecting mismatches with last
            char last = stack.peek()[0];
            if (c == ')') {
                if (last == '(') {
                    stack.pop();
                    continue;
                }
                return "NO";
            }
            if (c == ']') {
                if (last == '[') {
                    stack.pop();
                    continue;
                }
                return "NO";
            }
            if (c == '}') {
                if (last == '{') {
                    stack.pop();
                    continue;
                }
                return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
