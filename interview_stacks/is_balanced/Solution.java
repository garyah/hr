import java.io.*;
import java.util.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        // range check
        if (s.length() < 1 || s.length() > 1000) return "NO";

        // for stack, use array of characters, instead of string
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // retrieve next bracket
            char c = s.charAt(i);

            // push all left brackets
            if (c == '(' || c == '[' || c == '{') {
                stack.append(c);
                continue;
            }

            // ignore all non-bracket characters
            if (c != ')' && c != ']' && c != '}') {
                continue;
            }

            // stack cannot be empty at this point!
            if (stack.length() == 0) return "NO";

            // process right brackets, rejecting mismatches with last
            char last = stack.charAt(stack.length() - 1);
            if (c == ')') {
                if (last == '(') {
                    stack.setLength(stack.length() - 1);
                    continue;
                }
                return "NO";
            }
            if (c == ']') {
                if (last == '[') {
                    stack.setLength(stack.length() - 1);
                    continue;
                }
                return "NO";
            }
            if (c == '}') {
                if (last == '{') {
                    stack.setLength(stack.length() - 1);
                    continue;
                }
                return "NO";
            }
        }

        // if stack is empty, all things balanced out
        if (stack.length() == 0) return "YES";
        return "NO";
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
