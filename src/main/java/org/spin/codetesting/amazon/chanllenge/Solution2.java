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


class Result2 {

    /*
     * Complete the 'findTotalImbalance' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY rank as parameter.
     */

    public static long findTotalImbalance(List<Integer> rank) {
        int rank_index = 0;
        int cur_index = 0;
        int sum = 0;
        for (Integer n : rank) {
            cur_index = rank_index;
            List<Integer> sub_rank = new ArrayList<>();
            while (cur_index < rank.size()) {

                sub_rank.add(rank.get(cur_index));

                if (sub_rank.size() < 2) {
                    cur_index++;
                    continue;
                }
                List<Integer> new_subRank = sub_rank.stream().sorted().collect(Collectors.toList());
                sum += getImbalanceCount(new_subRank);
                cur_index++;
            }
            rank_index++;
        }
        return sum;
    }

    private static long getImbalanceCount(List<Integer> subRank) {
        if (subRank.size() == 1 || subRank.size() == 0) {
            return 0;
        }
        long imbalance_count = 0;
        for (int i = 0; i < subRank.size() - 1; i++) {
            if (subRank.get(i + 1) - subRank.get(i) > 1) {
                imbalance_count++;
            }
        }
        return imbalance_count;
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        System.out.println(Result2.findTotalImbalance(List.of(4, 1, 3, 2)));
//        System.out.println(Result2.findTotalImbalance(List.of(1, 2)));
//        System.out.println(Result2.findTotalImbalance(List.of(1, 5, 4)));
        System.out.println(Result2.findTotalImbalance(List.of(4, 4, 1, 3, 2)));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int rankCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> rank = IntStream.range(0, rankCount).mapToObj(i -> {
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
//        long result = Result.findTotalImbalance(rank);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
