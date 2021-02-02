package com.mylearning.v1.greedy;

public class CoinChangeProblem {
  
  public static void main(String[] args) {
    int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int input = 789;
    int index = denominations.length - 1;
    while (true) {
      int  denomination = findRightDenomination(denominations, input, index);
      if (input >= denomination) {
        System.out.println(denomination);
        input = input - denomination;
      }
      if (input == 0) break;
    }
  }
  
  private static int findRightDenomination(int[] denominations, int input, int index) {
    if (index < 0) {
      return 0;
    }
    if (input >= denominations[index]) {
      return denominations[index];
    }
    return findRightDenomination(denominations, input, --index);
  }
}