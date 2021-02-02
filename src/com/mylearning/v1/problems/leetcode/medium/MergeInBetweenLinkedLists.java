package com.mylearning.v1.problems.leetcode.medium;

public class MergeInBetweenLinkedLists {
  
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
    ListNode l = mergeInBetween(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
        3, 4, new ListNode(1000000, new ListNode(1000001, new ListNode(1000002))));
  }
  
  public static ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
    ListNode curr = l1;
    ListNode prev = null;
    ListNode startPrev = null;
    ListNode end = null;
    int i = 0;
    while (curr != null) {
      if (i == a) {
        startPrev = prev;
      }
      if (i == b) {
        end = curr.next;
      }
      prev = curr;
      curr = curr.next;
      i++;
    }
    ListNode l2Curr = l2;
    while (l2Curr.next != null) {
      l2Curr = l2Curr.next;
    }
    l2Curr.next = end;
    startPrev.next = l2;
    return l1;
  }
}
