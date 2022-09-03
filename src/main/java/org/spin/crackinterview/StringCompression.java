package org.spin.crackinterview;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("a"));
        System.out.println(compress("abc"));
    }

    static String compress(String str) {
        char[] carr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char record = '\0';
        for (int i = 0; i < carr.length; i++) {
            if (i == 0) {
                record = carr[i];
                count = 1;
            } else {
                if (carr[i] == carr[i - 1]) {
                    count++;
                    if (i == carr.length - 1) {
                        sb.append(record).append(count);
                    }
                } else {
                    sb.append(record).append(count);
                    record = carr[i];
                    count = 1;
                }
            }
        }
        if (sb.length() > str.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }
}
