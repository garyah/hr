import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int numberOfPositiveValues = 0;
        int numberOfNegativeValues = 0;
        int numberOfZeroValues = 0;
        for (int i : arr) {
            if (i > 0)
                numberOfPositiveValues += 1;
            else if (i < 0)
                numberOfNegativeValues += 1;
            else
                numberOfZeroValues += 1;
        }
        float ratioOfPositiveValues = (float) numberOfPositiveValues / (float) arr.length;
        float ratioOfNegativeValues = (float) numberOfNegativeValues / (float) arr.length;
        float ratioOfZeroValues = (float) numberOfZeroValues / (float) arr.length;
        System.out.println(ratioOfPositiveValues);
        System.out.println(ratioOfNegativeValues);
        System.out.println(ratioOfZeroValues);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
