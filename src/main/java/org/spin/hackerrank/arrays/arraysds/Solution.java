package org.spin.hackerrank.arrays.arraysds;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

//https://www.hackerrank.com/challenges/arrays-ds/problem
class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        Integer[] r = new Integer[a.size()];
        int idx = r.length - 1;
        for (Integer i : a) {
            r[idx] = i;
            idx--;
        }
        return new ArrayList<>(List.of(r));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> r = Result.reverseArray(a);
        System.out.println(Arrays.toString(r.toArray()));
        a = new ArrayList<>(List.of(1, 4, 3, 2));
        r = Result.reverseArray(a);
        System.out.println(Arrays.toString(r.toArray()));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> res = Result.reverseArray(arr);
//
//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
