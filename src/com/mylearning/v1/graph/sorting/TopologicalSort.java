package com.mylearning.v1.graph.sorting;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(8);
    TopologicalSort t = new TopologicalSort(nodes);
    t.addEdge(0, 2);
    t.addEdge(1, 2);
    t.addEdge(2, 4);
    t.addEdge(1, 3);
    t.addEdge(4, 5);
    t.addEdge(5, 6);
    t.addEdge(3, 5);
    t.addEdge(4, 7);
    t.sort();
  }
  
  private final List<Node> nodes;
  
  public TopologicalSort(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void addEdge(int from, int to) {
    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);
    fromNode.neighbors.add(toNode);
  }
  
  private void sort() {
    Stack<Node> stack = new Stack<>();
    for (Node node : nodes) {
      if (!node.visited) {
        sort(stack, node);
      }
    }
    while(!stack.isEmpty()) {
      Node node = stack.pop();
      System.out.print(node.name + " ");
    }
  }
  private void sort(Stack<Node> stack, Node node) {
    for (Node neighbor : node.neighbors) {
      if (!neighbor.visited) {
        sort(stack, neighbor);
      }
    }
    node.visited = true;
    stack.push(node);
  }
}
