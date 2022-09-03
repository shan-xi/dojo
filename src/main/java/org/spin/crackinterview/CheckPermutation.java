package org.spin.crackinterview;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(permutation("a", "a"));
        System.out.println(permutation("a", "ab"));
        System.out.println(permutation("ba", "cc"));

    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }

        }

        return true;
    }

}
