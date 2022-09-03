package org.spin.hackerrank.arrays.dynamicarrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/dynamic-array/problem?h_r=next-challenge&h_v=legacy
class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList<>();

        int lastAnswer = 0;
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (List<Integer> query : queries) {

            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int idx = (x ^ lastAnswer) % n;
            if (type == 1) {
                arr.get(idx).add(y);
            } else if (type == 2) {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                r.add(lastAnswer);
            }
        }
        return r;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of(1, 0, 5)));
        queries.add(new ArrayList<>(List.of(1, 1, 7)));
        queries.add(new ArrayList<>(List.of(1, 0, 3)));
        queries.add(new ArrayList<>(List.of(2, 1, 0)));
        queries.add(new ArrayList<>(List.of(2, 1, 1)));
        List<Integer> r = Result.dynamicArray(2, queries);
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
