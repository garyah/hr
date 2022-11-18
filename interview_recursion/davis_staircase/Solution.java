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
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int stepPerms(int n) {
        if (n < 1 || n > 36) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int numWays = 0;
        numWays += stepPerms(n - 3);
        numWays += stepPerms(n - 2);
        numWays += stepPerms(n - 1);
        return (int)((long)numWays % 10000000007l);
    }

}

public class Solution {
    // public static void main(String[] args) {
    //     for (int s = 0; s < 5; s++) {
    //         for (int n = 1; n <= 36; n++) {
    //             System.out.println("n = " + n + ", result = " + Result.stepPerms(n));
    //         }
    //     }
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, s).forEach(sItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int res = Result.stepPerms(n);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
