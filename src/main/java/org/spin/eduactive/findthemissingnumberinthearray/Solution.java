package org.spin.eduactive.findthemissingnumberinthearray;

//https://www.educative.io/m/find-the-missing-number

import java.util.*;

public class Solution {

    static int findMissingNumber(List<Integer> input) {

        int n = input.size()+1;
        int possible_sum = (1 + n) * n / 2;
        int sum = 0;
        for (Integer i : input) {
            sum += i;
        }
        return possible_sum - sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(3, 7, 1, 2, 8, 4, 5));
        System.out.println(Solution.findMissingNumber(arr));
    }
}
