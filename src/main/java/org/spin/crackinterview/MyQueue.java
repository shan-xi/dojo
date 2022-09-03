package org.spin.crackinterview;

import java.util.Stack;

public class MyQueue<T> {
    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(1);
        mq.add(2);
        mq.add(3);
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
    }
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.add(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
