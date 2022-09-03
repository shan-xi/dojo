package org.spin.hackerrank.arrays.arraysds2d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/2d-array/problem?isFullScreen=true
class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int sum = Integer.MIN_VALUE;
        for (int down = 2; down < 6; down++) {
            for (int right = 2; right < 6; right++) {
                int temp = arr.get(down - 2).get(right - 2) +
                        arr.get(down - 2).get(right - 1) +
                        arr.get(down - 2).get(right) +
                        arr.get(down - 1).get(right - 1) +
                        arr.get(down).get(right - 2) +
                        arr.get(down).get(right - 1) +
                        arr.get(down).get(right);

                if (temp > sum) {
                    sum = temp;
                }
            }
        }

//        for (List<Integer> l1 : arr) {
//            System.out.println();
//            for (Integer i : l1) {
//                System.out.print(i);
//            }
//        }
//        System.out.println();
        return sum;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> d1 = List.of(1, 1, 1, 0, 0, 0);
        List<Integer> d2 = List.of(0, 1, 0, 0, 0, 0);
        List<Integer> d3 = List.of(1, 1, 1, 0, 0, 0);
        List<Integer> d4 = List.of(0, 0, 0, 0, 0, 0);
        List<Integer> d5 = List.of(0, 0, 0, 0, 0, 0);
        List<Integer> d6 = List.of(0, 0, 0, 0, 0, 0);
        List<List<Integer>> a = new ArrayList<>();
        a.add(d1);
        a.add(d2);
        a.add(d3);
        a.add(d4);
        a.add(d5);
        a.add(d6);
        int r = Result.hourglassSum(a);
        System.out.println(r);

        d1 = List.of(-9, -9, -9, 1, 1, 1);
        d2 = List.of(0, -9, 0, 4, 3, 2);
        d3 = List.of(-9, -9, -9, 1, 2, 3);
        d4 = List.of(0, 0, 8, 6, 6, 0);
        d5 = List.of(0, 0, 0, -2, 0, 0);
        d6 = List.of(0, 0, 1, 2, 4, 0);
        a = new ArrayList<>();
        a.add(d1);
        a.add(d2);
        a.add(d3);
        a.add(d4);
        a.add(d5);
        a.add(d6);
        r = Result.hourglassSum(a);
        System.out.println(r);

        d1 = List.of(1, 1, 1, 0, 0, 0);
        d2 = List.of(0, 1, 0, 0, 0, 0);
        d3 = List.of(1, 1, 1, 0, 0, 0);
        d4 = List.of(0, 0, 2, 4, 4, 0);
        d5 = List.of(0, 0, 0, 2, 0, 0);
        d6 = List.of(0, 0, 1, 2, 4, 0);
        a = new ArrayList<>();
        a.add(d1);
        a.add(d2);
        a.add(d3);
        a.add(d4);
        a.add(d5);
        a.add(d6);
        r = Result.hourglassSum(a);
        System.out.println(r);
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
