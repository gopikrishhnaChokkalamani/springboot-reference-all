package com.mylearning.v1.tree.array.binarytree;

public class BinaryTreeImpl {
  
  public static void main(String[] args) {
    BinaryTreeImpl b = new BinaryTreeImpl(10);
    int i = 1;
    while (i < 10) {
      b.insert(i);
      i++;
    }
    b.print();
    System.out.println();
    b.preOrder(1);
    System.out.println();
    b.postOrder(1);
    System.out.println();
    b.levelOrder();
    b.delete(5);
    System.out.println();
    b.levelOrder();
  }

  int[] arr;
  int index;
  
  public BinaryTreeImpl(int size) {
    this.index = 1;
    this.arr = new int[size];
  }
  
  private boolean empty() {
    return arr == null || arr.length == 0;
  }
  
  private boolean full() {
    return index == arr.length;
  }
  
  private void insert(int data) {
    if (full()) {
      System.out.println("Binary Tree is Full");
    } else {
      arr[index] = data;
      index++;
    }
  }
  
  private void preOrder(int currIndex) {
    if (currIndex >= index) {
      return;
    }
    System.out.print(arr[currIndex] + " ");
    preOrder(currIndex * 2);
    preOrder(currIndex * 2 + 1);
  }
  
  private void postOrder(int currIndex) {
    if (currIndex >= index) {
      return;
    }
    postOrder(currIndex * 2);
    postOrder(currIndex * 2 + 1);
    System.out.print(arr[currIndex] + " ");
  }
  
  private void levelOrder() {
    for (int i = 1; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
  
  private void print() {
    if (empty()) {
      System.out.println("Binary Tree is Empty");
    } else {
      for (int i = 1; i < index - 1; i++) {
        System.out.print(arr[i] + " ");
      }
    }
  }
  
  private void delete(int data) {
    for (int i = 1; i < index - 1;i++) {
      if (arr[i] == data) {
        arr[i] = arr[index - 1];
        arr[index - 1] = 0;
        index--;
      }
    }
  }
}
