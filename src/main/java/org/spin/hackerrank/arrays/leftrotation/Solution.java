package org.spin.hackerrank.arrays.leftrotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/array-left-rotation/problem?h_r=next-challenge&h_v=legacy
class Result {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        Integer[] nr = new Integer[arr.size()];
        int steps = arr.size() - d % arr.size();
        for (int i = 0; i < arr.size(); i++) {
            if (i + steps < arr.size()) {
                nr[i + steps] = arr.get(i);
            } else {
                nr[i + steps - arr.size()] = arr.get(i);
            }
        }
        return new ArrayList<>(List.of(nr));

        // 0 1 2 3 4
        // 1,2,3,4,5
        // 5,1,2,3,4


//        for (int i = 0; i < d; i++) {
//            int idx = 0;
//            int firstEle = arr.get(0);
//            while (idx < arr.size() - 1) {
//                arr.set(idx, arr.get(idx + 1));
//                idx += 1;
//            }
//            arr.set(arr.size() - 1, firstEle);
//        }

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> r = Result.rotateLeft(4, arr);
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
