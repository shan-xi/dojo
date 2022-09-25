package org.spin.crackinterview;

import java.util.Stack;

public class TowersOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        int tower_count = 3;
        Tower[] towers = new Tower[tower_count];
        for (int i = 0; i < tower_count; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        towers[2].display();
    }

    static class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            disks = new Stack<>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                System.out.println("enter this="+this.index+", n=" + n + ", destination=" + destination.index + ", buffer=" + buffer.index);

                moveDisks(n - 1, buffer, destination);
                System.out.println("part1 => " + "n=" + n  + ", destination=" + buffer.index+ ", buffer=" + destination.index);

                moveTopTo(destination);
                System.out.println("part2 => " + "n=" + n + ", origin="+this.index+", destination=" + destination.index);

                buffer.moveDisks(n - 1, destination, this);
                System.out.println("part3 => " + "n=" + n + ", destination=" + destination.index + ", buffer=" + this.index);
                System.out.println("end");
            }
        }

        public void display() {
            while (!this.disks.isEmpty()) {
                System.out.println(this.disks.pop());
            }
        }
    }
}
