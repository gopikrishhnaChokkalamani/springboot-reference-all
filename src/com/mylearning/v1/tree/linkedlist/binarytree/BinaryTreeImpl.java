package com.mylearning.v1.tree.linkedlist.binarytree;

import com.mylearning.v1.tree.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeImpl {
  
  public static void main(String[] args) {
    BinaryTreeImpl b = new BinaryTreeImpl();
    int i = 0;
    while (i < 10) {
      b.insert(i);
      i++;
    }
    b.preOrder(b.root);
    System.out.println();
    b.postOrder(b.root);
    System.out.println();
    b.levelOrder();
    System.out.println();
    b.search(7);
    b.search(10);
    System.out.println();
    System.out.println("Height");
    b.height();
    System.out.println("Count");
    b.count();
    b.delete(5);
    b.delete(100);
    System.out.println("Height");
    b.height();
    System.out.println("Count");
    b.count();
    System.out.println("Width");
    b.width();
  }
  
  private Node root;
  
  private void insert(int data) {
    if (root == null) {
      root = new Node(data);
    } else {
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        Node currNode = queue.remove();
        if (currNode.left == null) {
          currNode.left = new Node(data);
          break;
        } else if (currNode.right == null) {
          currNode.right = new Node(data);
          break;
        } else {
          queue.add(currNode.left);
          queue.add(currNode.right);
        }
      }
    }
  }
  
  private void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
  
  private void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    System.out.print(node.data + " ");
    postOrder(node.right);
  }
  
  private void levelOrder() {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      System.out.print(currNode.data + " ");
      if (currNode.left != null) {
        queue.add(currNode.left);
      }
      if (currNode.right != null) {
        queue.add(currNode.right);
      }
    }
  }
  
  private void search(int data) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      if (currNode.data == data) {
        System.out.println(data + " - Data Found");
        return;
      }
      if (currNode.left != null) {
        queue.add(currNode.left);
      }
      if (currNode.right != null) {
        queue.add(currNode.right);
      }
    }
    System.out.println(data + " - Data Not Found");
  }
  
  private void delete(int data) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      if (currNode.data == data) {
        System.out.println(data + " - Data Found for Deletion");
        currNode.data = findDeepestNode().data;
        deleteDeepestNode();
        return;
      }
      if (currNode.left != null) {
        queue.add(currNode.left);
      }
      if (currNode.right != null) {
        queue.add(currNode.right);
      }
    }
    System.out.println(data + " - Data Not Found for Deletion");
  }
  
  private void deleteDeepestNode() {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Node deepNode = null;
    while (!queue.isEmpty()) {
      deepNode = queue.remove();
      if (deepNode.left == null) {
        deepNode.right = null;
        return;
      }
      if (deepNode.right == null) {
        deepNode.left = null;
        return;
      }
      if (deepNode.left != null) {
        queue.add(deepNode.left);
      }
      if (deepNode.right != null) {
        queue.add(deepNode.right);
      }
    }
  }
  
  private Node findDeepestNode() {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Node deepNode = null;
    while (!queue.isEmpty()) {
      deepNode = queue.remove();
      if (deepNode.left != null) {
        queue.add(deepNode.left);
      }
      if (deepNode.right != null) {
        queue.add(deepNode.right);
      }
    }
    return deepNode;
  }
  
  private void height() {
    if (root == null) {
      return;
    } else {
      int height = height(root);
      System.out.println(height);
    }
  }
  
  private int height(Node node) {
    if (node == null) {
      return 0;
    }
    //int lheight  = height(node.left);
    //int rheight = height(node.right);
    //return lheight + rheight + 1;
    return Math.max(height(node.left), height(node.right)) + 1;
  }
  
  private void count() {
    if (root == null) {
      return;
    } else {
      int count = count(root);
      System.out.println(count);
    }
  }
  
  private int count(Node node) {
    if (node == null) {
      return 0;
    }
    //int lcount = count(node.left);
    //int rCount = count(node.right);
    //return lcount + rCount + 1;
    return count(node.left) + count(node.right) + 1;
  }
  
  private void width() {
    if (root == null) {
      return;
    } else {
      int width = 0;
      for (int i = 0; i < height(root); i++) {
        int tmp = width(root, i);
        if (tmp > width) {
          width = tmp;
        }
      }
      System.out.println(width);
    }
  }
  
  private int width(Node node, int lvl) {
    if (node == null) {
      return 0;
    }
    if (lvl == 1) {
      return 1;
    }
    return width(node.left, lvl - 1) + width(node.right, lvl - 1);
  }
}
