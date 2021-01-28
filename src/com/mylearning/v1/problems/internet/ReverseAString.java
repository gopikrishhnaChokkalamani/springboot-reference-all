package com.mylearning.v1.problems.internet;

public class ReverseAString {
  
  public static void main(String[] args) {
    String s = "MODULE";
    int i = s.length() - 1;
    while(i >= 0) {
      System.out.print(s.charAt(i));
      i--;
    }
  }
}
