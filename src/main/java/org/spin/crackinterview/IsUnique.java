package org.spin.crackinterview;

public class IsUnique {
    public static void main(String[] args) {
//        System.out.println(IsUnique.isUniqueChars2("abc"));
        System.out.println(IsUnique.isUniqueChars2("aaa"));
    }

    static boolean isUniqueChars(String a) {
        if (a.length() > 128) {
            return false;
        }
        boolean[] chkArr = new boolean[128];
        for (int i = 0; i < a.length(); i++) {
            int c = a.charAt(i);
            if (chkArr[c]) {
                return false;
            } else {
                chkArr[c] = true;
            }
        }
        return true;
    }

    static boolean isUniqueChars2(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            boolean chk = (checker & (1 << val)) > 0;
            if (chk) {
                return false;
            }
            checker = checker | (1 << val);
            System.out.println(checker);
        }
        return true;
    }
}
