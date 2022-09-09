package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;
import org.spin.crackinterview.util.TreeNodeInt;

import java.util.HashMap;

public class PathsWithSum {
    public static void main(String[] args) {
        TreeNodeInt root = new TreeNodeInt(10);
        root.left = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(3);
        root.left.left.right = new TreeNodeInt(-2);
        root.left.right = new TreeNodeInt(2);
        root.left.right.right = new TreeNodeInt(1);
        root.left.left.left = new TreeNodeInt(3);
        root.right = new TreeNodeInt(-3);
        root.right.right = new TreeNodeInt(11);
        PathsWithSum r = new PathsWithSum();
        System.out.println(r.countPathsWithSum(root, 8));
        System.out.println(r.countPathsWithSum2(root, 8));
    }

    int countPathsWithSum(TreeNodeInt root, int targetSum) {
        if (root == null) return 0;

        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    int countPathsWithSumFromNode(TreeNodeInt node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.data;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }

    int countPathsWithSum2(TreeNodeInt root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathsWithSum(TreeNodeInt node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0;

        runningSum += node.data;
        System.out.println("runningSum="+runningSum+", node.data="+node.data+", origin runningSum="+(runningSum-node.data));
        int sum = runningSum - targetSum;
        System.out.println("sum="+sum);
        int totalPaths = pathCount.getOrDefault(sum, 0);
        System.out.println("totalPaths="+totalPaths);
        System.out.println("pathCount="+pathCount);

        if (runningSum == targetSum) {
            totalPaths++;
            System.out.println("totalPaths++");
        }
        System.out.println("totalPaths="+totalPaths);

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
