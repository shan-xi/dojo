package org.spin.crackinterview;

public class SumDigit {
    // log n
    static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // <== 10^d, d = log n
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(100));
        System.out.println(sumDigits(111));
    }
}
