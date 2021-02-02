package com.mylearning.v1.problems.leetcode.medium;

public class AddTwoNumbers {
  
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
    AddTwoNumbers a = new AddTwoNumbers();
    String first = "753865680";
    String second = "798580876";
    char[] digitArray = String.valueOf(first).toCharArray();
    ListNode n = null;
    for (int i = 0; i < digitArray.length; i++) {
      ListNode ln = new ListNode(Integer.valueOf(String.valueOf(digitArray[i])), n);
      n = ln;
    }
  
    char[] digitArray1 = String.valueOf(second).toCharArray();
    ListNode n2 = null;
    for (int i = 0; i < digitArray1.length; i++) {
      ListNode ln = new ListNode(Integer.valueOf(String.valueOf(digitArray1[i])), n2);
      n2 = ln;
    }
    
    ListNode ans = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
  }
  
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0);
    int carry = 0;
    ListNode curr = l;
    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      carry = sum / 10;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return l.next;
  }
}



















