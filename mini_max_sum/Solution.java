import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minimumSum = 0;
        long maximumSum = 0;
        for (int indexToExclude = 0; indexToExclude < arr.length; indexToExclude++) {
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != indexToExclude) sum += arr[i];
            }
            if (minimumSum == 0 || sum < minimumSum) minimumSum = sum;
            if (maximumSum == 0 || sum > maximumSum) maximumSum = sum;
        }
        System.out.println(minimumSum + " " + maximumSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
