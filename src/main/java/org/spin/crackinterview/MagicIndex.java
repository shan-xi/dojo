package org.spin.crackinterview;

public class MagicIndex {
    public static void main(String[] args) {
        MagicIndex mi = new MagicIndex();
        int[] ar = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(mi.magicFast(ar));
        System.out.println(mi.magicFast2(ar));
    }

    int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    int magicFast(int[] array, int start, int end) {
        if (end < start) return -1;
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    int magicFast2(int[] array) {
        return magicFast2(array, 0, array.length - 1);
    }

    int magicFast2(int[] array, int start, int end) {
        System.out.println("start="+start+", "+"end="+end);
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);
        return right;
    }

}
