package org.spin.crackinterview;

public class PermutationOfPalindrome2 {

    public static void main(String[] args) {
//        System.out.println(isPermutationOfPalindrome("abcdabcde"));
//        System.out.println(isPermutationOfPalindrome("abcd"));
//        System.out.println(isPermutationOfPalindrome("aaaaa"));
//        System.out.println(isPermutationOfPalindrome("ab"));
//        System.out.println(isPermutationOfPalindrome("a"));
        System.out.println(isPermutationOfPalindrome("aabbccdd"));
    }

    static boolean isPermutationOfPalindrome(String phrase) {
        System.out.println(phrase);
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
            System.out.println(bitVector);
        }
        return bitVector;
    }

    static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = 1 << index;
        System.out.println("bitVector="+bitVector+", mask="+mask+", index="+index+", (bitVector & mask)="+(bitVector & mask));
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            System.out.println("bitVector & ~mask="+(bitVector & ~mask));
            bitVector &= ~mask;
        }
        return bitVector;
    }

    static boolean checkExactlyOneBitSet(int bitVector) {
        System.out.println(bitVector+"&"+(bitVector - 1)+"="+(bitVector & (bitVector - 1)));
        System.out.println("checkExactlyOneBitSet="+(bitVector & (bitVector - 1))+", bitVector="+bitVector);
        return (bitVector & (bitVector - 1)) == 0;
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
