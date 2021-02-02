package com.mylearning.v1.problems.leetcode.hard;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
  
  public static class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
      this.val = val;
    }
    
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));
    ListNode[] lists = {l1, l2, l3};
    Queue<Integer> queue = new PriorityQueue<>();
    for (ListNode n : lists) {
      ListNode root = n;
      while (root != null) {
        queue.add(root.val);
        root = root.next;
      }
    }
    ListNode node = new ListNode();
    ListNode n1 = node;
    while (!queue.isEmpty()) {
      ListNode newNode = new ListNode(queue.remove());
      node.next = newNode;
      node = newNode;
    }
    int i = 0;
  }
  
}
