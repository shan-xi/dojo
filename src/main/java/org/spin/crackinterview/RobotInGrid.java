package org.spin.crackinterview;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][]{
                {true, true, false, false},
                {false, true, false, false},
                {false, true, true, false},
                {false, false, true, true}};
        /**
         * 1 1 0 0
         * 0 1 0 0
         * 0 1 1 0
         * 0 0 1 1
         */
        RobotInGrid r = new RobotInGrid();
        var rr = r.getPath(maze);
        for (Point p : rr) {
            System.out.println(p);
        }
        var rr2 = r.getPath2(maze);
        for (Point p : rr2) {
            System.out.println(p);
        }
    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    ArrayList<Point> getPath2(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0 && col == 0);
        if (isAtOrigin ||
                getPath(maze, row, col - 1, path, failedPoints) ||
                getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Point))
            return false;
        Point other = (Point) o;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public final int hashCode() {
        return this.row + this.col;
    }

    @Override
    public String toString() {
        return this.row + " " + this.col;
    }
}
