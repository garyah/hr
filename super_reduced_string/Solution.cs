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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static string superReducedString(string s)
    {
        // res - resulting string
        string res = s;
        
        while (res != "") {
            // r - working value of string
            string r = "";
            // c0 - character to match
            char c0 = res[0];
            for (int i = 1; i < res.Length; i++) {
                if (res[i] == c0) {
                    c0 = '0'; // sentinel for new match
                    continue;
                }
                if (c0 != '0') {
                    r = r + c0;
                }
                c0 = res[i];
                if (i == res.Length - 1) {
                    r = r + c0;
                }
            }
            if (r.Length == res.Length) break;
            res = r;
        }
        
        if (res == "") {
            return "Empty String";
        }
        return res;
    }

}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string s = Console.ReadLine();

        string result = Result.superReducedString(s);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
