package com.mylearning.v1.problems.leetcode.easy;

public class NeedleHayStackStrStr {
  
  public static void main(String[] args) {
    String h = "aaa";
    String n = "aaaa";
    
    int ja = h.indexOf('a');
  
    if (n == null) {
      System.out.println(0);
      return;
    }
    if (n.length() == 0) {
      System.out.println(0);
      return;
    }
    
    int j = 0;
    int i = 0;
    int index = -1;
    while (i != h.length()) {
      if (h.charAt(i) == n.charAt(j)) {
        index = i;
        while (j != n.length()) {
          if (h.charAt(i) != n.charAt(j)) {
            System.out.println("no match");
            return;
          }
          i++;
          j++;
        }
        System.out.println(index);
        return;
      } else {
        index = -1;
      }
      i++;
    }
    System.out.println(index);
  }
}
