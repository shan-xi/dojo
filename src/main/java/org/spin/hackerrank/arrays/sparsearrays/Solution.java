package org.spin.hackerrank.arrays.sparsearrays;

import java.io.IOException;
import java.util.*;

//https://www.hackerrank.com/challenges/array-left-rotation/problem?h_r=next-challenge&h_v=legacy
class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> r = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        for (String s : strings) {
            if (!m.containsKey(s)) {
                m.put(s, 1);
            } else {
                m.put(s, m.get(s) + 1);
            }
        }
        for (String s : queries) {
            r.add(m.getOrDefault(s, 0));
        }
        return r;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>(List.of("aba", "baba", "aba", "xzxb"));
        List<String> queries = new ArrayList<>(List.of("aba", "xzxb", "ab"));
        List<Integer> r = Result.matchingStrings(strings, queries);
        System.out.println(Arrays.toString(r.toArray()));
        strings = new ArrayList<>(List.of("def","de","fgh"));
        queries = new ArrayList<>(List.of("de","lmn","fgh"));
        r = Result.matchingStrings(strings, queries);
        System.out.println(Arrays.toString(r.toArray()));
        strings = new ArrayList<>(List.of("abcde","sdaklfj","asdjf","na","basdn","sdaklfj","asdjf","na","asdjf","na","basdn","sdaklfj","asdjf"));
        queries = new ArrayList<>(List.of("abcde","sdaklfj","asdjf","na","basdn"));
        r = Result.matchingStrings(strings, queries);
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
