package org.spin.crackinterview.util;

import java.util.Objects;
import java.util.Random;

public class TreeNodeInt {
    public int data;
    public TreeNodeInt left;
    public TreeNodeInt right;
    public TreeNodeInt parent;
    private int size = 0;

    public TreeNodeInt(int d) {
        data = d;
        size = 1;
    }

    public TreeNodeInt getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNodeInt(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNodeInt(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public TreeNodeInt find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}


