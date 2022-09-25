package org.spin.codetesting.amazon.chanllenge;

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


class Result1 {

    /*
     * Complete the 'maxSetSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY riceBags as parameter.
     */

    public static int maxSetSize(List<Integer> riceBags) {
        List<Integer> new_riceBags = riceBags.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        boolean is_got = false;
        for (int size : new_riceBags) {
            int double_size = size * size;
            if (map.get(size) != null) {
                map.put(double_size, map.get(size) + 1);
                is_got = true;
            } else {
                map.put(double_size, 1);
            }
            if(is_got) {
                if (map.get(double_size) > max) {
                    max = map.get(double_size);
                }
            }
        }

        if (!is_got) {
            return -1;
        } else {
            return max;
        }
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        System.out.println(Result1.maxSetSize(List.of(3, 9, 4, 2, 16)));
        System.out.println(Result1.maxSetSize(List.of(625, 4, 2, 5, 25)));
        System.out.println(Result1.maxSetSize(List.of(7, 4, 8, 9)));
        System.out.println(Result1.maxSetSize(List.of(2,2)));
        System.out.println(Result1.maxSetSize(List.of(2, 2, 2, 2, 2, 2, 2, 2, 2)));

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int riceBagsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> riceBags = IntStream.range(0, riceBagsCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.maxSetSize(riceBags);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
