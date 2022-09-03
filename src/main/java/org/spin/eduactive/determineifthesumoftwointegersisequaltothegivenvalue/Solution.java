package org.spin.eduactive.determineifthesumoftwointegersisequaltothegivenvalue;

//https://www.educative.io/m/sum-of-two-values

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    static boolean findSumOfTwo(int[] A, int val) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (!set.contains(i)) {
                set.add(val - i);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 7, 1, 2, 8, 4, 3};
        System.out.println(Solution.findSumOfTwo(A, 10));
        A = new int[]{5, 7, 1, 2, 8, 4, 3};
        System.out.println(Solution.findSumOfTwo(A, 19));
    }
}
