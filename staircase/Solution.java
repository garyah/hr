import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int line = 0; line < n; line++) {
            for (int numSpaces = 0; numSpaces < n - 1 - line; numSpaces++) { System.out.print(" "); }
            for (int numHashes = 0; numHashes < line + 1; numHashes++) { System.out.print("#"); }
            System.out.println("");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
