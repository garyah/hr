using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(string s)
    {
        // f[] - for letters of alphabet, true if found in s, false otherwise
        var f = new bool['z' - 'a' + 1];
        foreach (char c in s) {
            f[c - 'a'] = true;
        }
        // maxLen - length of longest string with just two alternating characters,
        //  return value
        int maxLen = 0;
        for (int i = 0; i < f.Length; i++) {
            for (int j = i + 1; j < f.Length; j++) {
                if (f[i] && f[j]) {
                    // if valid combination of letters to leave in string
                    // c0 = last character seen, use sentinel
                    char c0 = '0';
                    // len = length of valid string for this combination
                    int len = 0;
                    foreach (char c in s) {
                        if (c != 'a' + i && c != 'a' + j) continue; // letter to remove
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

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int l = Convert.ToInt32(Console.ReadLine().Trim());

        string s = Console.ReadLine();

        int result = Result.alternate(s);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
