package com.mylearning.v1.problems.internet;

public class IsPalindrome {
  
  public static void main(String[] args) {
    String s = "MADAM";
    //String s = "RACE CAR";
    //s.replace(" ", "");
    System.out.println(isPalindrome(s, 0, s.length() - 1));
    System.out.println(isPalindrome(s));
  }
  
  private static boolean isPalindrome(String s) {
    String s1 = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      s1 += s.charAt(i);
    }
    return s1.equalsIgnoreCase(s);
  }
  
  private static boolean isPalindrome(String s, int i, int j) {
    if (i > j) return true;
    if (s.charAt(i) == s.charAt(j)) return isPalindrome(s, i + 1, j - 1);
    return false;
  }
}