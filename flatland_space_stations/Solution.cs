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

class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int m = c.Length;
        if (m == n) {
            return 0;
        }
        int maxCitiesDistance = 0;
        Array.Sort(c);
        // for (int cityIdx = 0; cityIdx < n; cityIdx++) {
            int minCityDistance = 999999;
            int idxOfCurrentGap = 0;
            for (int stationsIdx = 0; stationsIdx < m; stationsIdx++) {
                // if (cityIdx == c[stationsIdx]) {
                //     minCityDistance = 0;
                //     break;
                // }
                // var distance = Math.Abs(c[stationsIdx] - cityIdx);
                // if (distance < minCityDistance) {
                //     minCityDistance = distance;
                // }
                if (stationsIdx == c[stationsIdx]) {
                    idxOfCurrentGap = stationsIdx;
                    continue;
                }
                var distance = c[stationsIdx] - idxOfCurrentGap / 2;
                idxOfCurrentGap = c[stationsIdx];
                if (distance > maxCitiesDistance) {
                    maxCitiesDistance = distance;
                }
            }
            // if (minCityDistance > maxCitiesDistance) {
            //     maxCitiesDistance = minCityDistance;
            // }
        // }
        return maxCitiesDistance;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] nm = Console.ReadLine().Split(' ');

        int n = Convert.ToInt32(nm[0]);

        int m = Convert.ToInt32(nm[1]);

        int[] c = Array.ConvertAll(Console.ReadLine().Split(' '), cTemp => Convert.ToInt32(cTemp))
        ;
        int result = flatlandSpaceStations(n, c);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
