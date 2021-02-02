package com.mylearning.v1.problems.leetcode.easy;

import java.util.List;

public class MergeTwoSortedLinkedLists {
  
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
    ListNode l = mergeTwoLists(null, new ListNode(0));
  }
  
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curr = new ListNode(0);
    ListNode tmp = curr;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        tmp.next = new ListNode(l1.val);
        tmp = tmp.next;
        l1 = l1.next;
      } else {
        tmp.next = new ListNode(l2.val);
        tmp = tmp.next;
        l2 = l2.next;
      }
    }
    while (l2 != null) {
      tmp.next = new ListNode(l2.val);
      tmp = tmp.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      tmp.next = new ListNode(l1.val);
      tmp = tmp.next;
      l1 = l1.next;
    }
    return curr.next;
  }
}
