package com.mylearning.v1.problems.leetcode.medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
  
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
      this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  public static void main(String[] args) {
    TreeNode n = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    List<List<Integer>> order = levelOrder(n);
    for (List<Integer> o : order) {
      for (Integer i : o) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
  
  private static List<List<Integer>> levelOrder(TreeNode n) {
    if (n != null) {
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(n);
      List<List<Integer>> order = new ArrayList<>();
      Queue<Integer> levels = new ArrayDeque<>();
      levels.add(1);
      int level = 1;
      List<Integer> innerOrder = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.remove();
        int currLevel = levels.remove();
        if (level == currLevel) {
          innerOrder.add(node.val);
        } else {
          level = currLevel;
          order.add(innerOrder);
          innerOrder = new ArrayList<>();
          innerOrder.add(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
          levels.add(level + 1);
        }
        if (node.right != null) {
          queue.add(node.right);
          levels.add(level + 1);
        }
      }
      order.add(innerOrder);
      return order;
    }
    return new ArrayList<>();
  }
}
