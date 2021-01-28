package com.mylearning.v1.tree.linkedlist.avl;

import com.mylearning.v1.tree.Node;

public class AVLTreeImpl {
  
  public static void main(String[] args) {
    AVLTreeImpl a = new AVLTreeImpl();
    int i = 1;
    while (i < 10) {
      a.insert(i);
      i++;
    }
    int oi = 0;
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
    return reBalance(node);
  }
  
  private Node reBalance(Node node) {
    node.height = updateHeight(node);
    int balance = balance(node);
    if (balance > 1) {
      if (getHeight(node.right.right) > getHeight(node.right.left)) {
        node = leftRotate(node);
      } else {
        node.right = rightRotate(node.right);
        node = leftRotate(node);
      }
    } else if (balance < -1) {
      if (getHeight(node.left.left) > getHeight(node.left.right)) {
        node = rightRotate(node);
      } else {
        node.left = leftRotate(node.left);
        node = rightRotate(node);
      }
    }
    return node;
  }
  
  private Node leftRotate(Node node) {
    Node newRoot = node.right;
    Node tmp = newRoot.left;
    newRoot.left = node;
    node.right = tmp;
    node.height = updateHeight(node);
    newRoot.height = updateHeight(newRoot);
    return newRoot;
  }
  
  private Node rightRotate(Node node) {
    Node newRoot = node.left;
    Node tmp = newRoot.right;
    newRoot.right = node;
    node.left = tmp;
    node.height = updateHeight(node);
    newRoot.height = updateHeight(newRoot);
    return newRoot;
  }
  
  private int updateHeight(Node n) {
    if (n == null) {
      return 0;
    }
    return Math.max(updateHeight(n.left), updateHeight(n.right)) + 1;
  }
  
  private int balance(Node node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.right) - getHeight(node.left);
  }
  
  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }
  
  private void delete(int data) {
    if (root == null) {
      System.out.println("Tree is Empty");
    } else {
      root = delete(root, data);
    }
  }
  
  private Node delete(Node node, int data) {
    if (node == null) {
      System.out.println(data + " - Data not found");
      return null;
    }
    if (data < node.data) {
      node.left = delete(node.left, data);
    } else if (data > node.data) {
      node.right = delete(node.right, data);
    } else {
      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left != null && node.right == null) {
        node = node.left;
      } else if (node.right != null && node.left == null) {
        node = node.right;
      } else {
        Node tmp = node;
        Node smallestNode = findSmallestNodeInRightSubTree(tmp.right);
        node.data = smallestNode.data;
        node = delete(node.right, smallestNode.data);
      }
      return node;
    }
    return reBalance(node);
  }
  
  private Node findSmallestNodeInRightSubTree(Node node) {
    if (node.left == null) {
      return node;
    }
    return findSmallestNodeInRightSubTree(node.left);
  }
}