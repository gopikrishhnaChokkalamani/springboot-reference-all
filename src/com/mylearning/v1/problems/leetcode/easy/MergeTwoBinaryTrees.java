package com.mylearning.v1.problems.leetcode.easy;

public class MergeTwoBinaryTrees {
  
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
    TreeNode t1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(5)), new TreeNode(2));
    TreeNode t2 = new TreeNode(2, new TreeNode(1, new TreeNode(4), null), new TreeNode(3, new TreeNode(7), null));
    TreeNode t = mergeTrees(t1, t2);
    int i = 0;
  }
  
  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    return preOrder(t1, t2);
  }
  
  private static TreeNode preOrder(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    } else {
      if (t1 == null) {
        return new TreeNode(t2.val);
      } else if (t2 == null) {
         t1.val += (t2 == null) ? 0 : t2.val;
         return t1;
      } else {
        t1.val += (t2 == null) ? 0 : t2.val;
      }
    }
    t1 = preOrder((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
    t1 = preOrder((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);
    return t1;
  }
  
//  easy solution
//      if (t1 == null) {
//    return t2;
//  }
//    if (t2 == null) {
//    return t1;
//  }
//  t1.val += t2.val;
//  t1.left = preOrder(t1.left, t2.left);
//  t1.right = preOrder(t1.right, t2.right);
//    return t1;
}
