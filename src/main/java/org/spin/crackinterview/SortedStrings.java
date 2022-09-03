package org.spin.crackinterview;



public class SortedStrings {
    public static void main(String[] args) {
        SortedStrings s =new SortedStrings();
        s.printSortedStrings(3);
    }
    int numChars = 26;
    int count = 0;

    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isinOrder(prefix)) {
                System.out.println(prefix);
            }
            System.out.println(++count);
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    boolean isinOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }

        return true;
    }

    char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }
}