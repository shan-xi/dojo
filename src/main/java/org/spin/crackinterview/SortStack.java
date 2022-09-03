package org.spin.crackinterview;

import java.util.Objects;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        SortStack ss = new SortStack();
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(10);
        s.push(1);
        s.push(2);
        s.push(6);
        ss.sort2(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }

    void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();
        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    //https://javabypatel.blogspot.com/2019/05/sort-stack-using-merge-sort.html#:~:text=Merge%20sort%20uses%20divide%20and,the%20complete%20array%20gets%20sorted.
    private static void sort2(Stack<Integer> stack) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (stack.size() != 0) {
            if (stack.size() % 2 == 0) {
                s1.push(stack.pop());
            } else {
                s2.push(stack.pop());
            }
        }
        if (s1.size() > 1) {
            sort2(s1);
        }
        if (s2.size() > 1) {
            sort2(s2);
        }
        merge(s1, s2, stack);
    }

    private static void merge(Stack<Integer> s1, Stack<Integer> s2, Stack<Integer> stack) {
        Stack<Integer> mergedStack = new Stack<>();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() > s2.peek()) {
                mergedStack.push(s2.pop());
            } else {
                mergedStack.push(s1.pop());
            }
        }
        while (!s1.isEmpty()) {
            mergedStack.push(s1.pop());
        }
        while (!s2.isEmpty()) {
            mergedStack.push(s2.pop());
        }
        while (!mergedStack.isEmpty()) {
            stack.push(mergedStack.pop());
        }
    }
}
