package com.mylearning.v1.tree.array.heap;

public class MaxHeapImpl {
  
  public static void main(String[] args) {
    MaxHeapImpl m = new MaxHeapImpl(10);
    int i = 1;
    while (i < 10) {
      m.insert(i);
      i++;
    }
    m.delete();
  }
  
  private int[] arr;
  private int index;
  
  public MaxHeapImpl(int size) {
    this.arr = new int[size];
    this.index = 1;
  }
  
  private boolean empty() {
    return arr == null || arr.length == 0;
  }
  
  private boolean full() {
    return index == arr.length;
  }
  
  private void insert(int data) {
    if (full()) {
      System.out.println("Tree is Full");
    } else {
      arr[index] = data;
      System.out.println("After Addition");
      print();
      bottomToTop(index);
      System.out.println("After Heapification");
      print();
      index++;
    }
  }
  
  private void bottomToTop(int currIndex) {
    int parent = currIndex / 2;
    if (parent == 0) {
      return;
    }
    if (arr[parent] < arr[currIndex]) {
      int tmp = arr[currIndex];
      arr[currIndex] = arr[parent];
      arr[parent] = tmp;
    }
    bottomToTop(parent);
  }
  
  private void delete() {
    if (empty()) {
      System.out.println("Tree is Empty");
    } else {
      int newIndex = index - 1;
      arr[1] = arr[newIndex];
      arr[newIndex] = 0;
      index = newIndex - 1;
      System.out.println("After Deletion");
      print();
      topToBottom(1);
      System.out.println("After Heapification");
      print();
    }
  }
  
  private void topToBottom(int currIndex) {
    int leftChild = currIndex * 2;
    int rightChild = currIndex * 2 + 1;
    if (leftChild > index || rightChild > index) {
      return;
    }
    if (arr[leftChild] > arr[rightChild]) {
      int tmp = arr[currIndex];
      arr[currIndex] = arr[leftChild];
      arr[leftChild] = tmp;
      currIndex = leftChild;
    } else {
      int tmp = arr[currIndex];
      arr[currIndex] = arr[rightChild];
      arr[rightChild] = tmp;
      currIndex = rightChild;
    }
    topToBottom(currIndex);
  }
  
  private void print() {
    if (empty()) {
      System.out.println("Binary Tree is Empty");
    } else {
      for (int i = 1; i <= index; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  }
}