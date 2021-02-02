package com.mylearning.v1.tree.linkedlist.binarytree;

import com.mylearning.v1.tree.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTreeImpl {
  
  public static void main(String[] args) {
    BinarySearchTreeImpl b = new BinarySearchTreeImpl();
    b.insert(40);
    b.insert(35);
    b.insert(45);
    b.insert(25);
    b.insert(37);
    b.insert(42);
    b.insert(47);
    b.search(37);
    b.search(100);
    b.delete(45);
    b.levelOrder();
  }
  
  private Node root;
  
  private void insert(int data) {
    if (root == null) {
      root = new Node(data);
    } else {
      root = insert(root, data);
    }
  }
  
  private Node insert(Node node, int data) {
    if (node == null) {
      node = new Node(data);
    } else if (data < node.data) {
      node.left = insert(node.left, data);
    } else {
      node.right = insert(node.right, data);
    }
    return node;
  }
  
  private void search(int data) {
    if (root == null) {
      System.out.println("Tree is Empty!");
    } else if (root.data == data) {
      System.out.println(data + " - Data Found");
    } else {
      search(root, data);
    }
  }
  
  private void search(Node node, int data) {
    if (node == null) {
      System.out.println(data + " - Data Not Found");
      return;
    } else  if (data == node.data) {
      System.out.println(data + " - Data Found");
      return;
    } else if (data < node.data) {
      search(node.left, data);
    } else {
      search(node.right, data);
    }
  }
  
  private void delete(int data) {
    if (root == null) {
      System.out.println("Tree is Empty!");
    } else {
      root = delete(root, data);
    }
  }
  
  private Node delete(Node node, int data) {
    if (node == null) {
      System.out.println(data + " - Data Not Found");
      return null;
    } else if (data < node.data) {
      node.left = delete(node.left, data);
    } else if (data > node.data) {
      node.right = delete(node.right, data);
    } else {
      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left != null && node.right == null) {
        node = node.left;
      } else if (node.left == null && node.right != null) {
        node = node.right;
      } else {
        Node tmp = node;
        Node smallestNode = findSmallestNodeFromRightSubTree(tmp.right);
        node.data = smallestNode.data;
        node.right = delete(node.right, smallestNode.data);
      }
    }
    return node;
  }
  
  private Node findSmallestNodeFromRightSubTree(Node node) {
    if (node.left == null) {
      return node;
    } else {
      return findSmallestNodeFromRightSubTree(node.left);
    }
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
}
