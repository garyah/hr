import java.io.*;
// use for BigInteger variation of solution
import java.math.BigInteger;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        int len = n.length();

        // range checking
        if (len > 100000) return 0;
        if (k < 1 || k > 100000) return 0;

        // Integer sum = sumOfDigits(n);
        // sum *= k;

        // alternative version of above code block, using BigInteger
        BigInteger sum = sumOfDigitsExtended(n);
        sum = sum.multiply(BigInteger.valueOf((long)k));

        System.out.println(sum); // DEBUG
        return superDigit(sum.toString());

        // This version of the code blew up, given limits on strings in memory
        // StringBuilder n_sb = new StringBuilder(n);
        // for (int i = 1; i < k; i++) {
        //     n_sb.append(n);
        // }
        // return superDigit(n_sb.toString());
    }

    // private static Integer sumOfDigits(String n) {
    //     int len = n.length();

    //     int sum = 0;
    //     for (int i = 0; i < len; i++) {
    //         sum += Integer.parseInt(n.substring(i, i + 1));
    //     }
    //     return sum;
    // }

    // alternative version of above previous function, using BigInteger
    private static BigInteger sumOfDigitsExtended(String n) {
        int len = n.length();

        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < len; i++) {
            sum = sum.add(BigInteger.valueOf(Long.parseLong(n.substring(i, i + 1))));
        }
        return sum;
    }

    private static int superDigit(String p) {
        int len = p.length();

        // range checking
        if (len == 0) return 0;

        // terminal case
        if (len == 1) return Integer.parseInt(p);

        // Integer sum = sumOfDigits(p);

        // alternative version of above code block, using BigInteger
        BigInteger sum = sumOfDigitsExtended(p);

        System.out.println(sum); // DEBUG
        return superDigit(sum.toString());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
