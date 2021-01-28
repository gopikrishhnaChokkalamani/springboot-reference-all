package com.mylearning.v1.graph.search;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.List;
import java.util.Stack;

public class DFSImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(7);
    DFSImpl b = new DFSImpl(nodes);
    GraphUtility.initializeUnDirectedUnWeightedEdges(nodes);
    b.dfs();
  }
  
  private final List<Node> nodes;
  
  public DFSImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void dfs() {
    for (Node node : nodes) {
      if (!node.visited) {
        dfs(node);
      }
    }
  }
  
  private void dfs(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.add(node);
    while (!stack.isEmpty()) {
      Node currNode = stack.pop();
      currNode.visited = true;
      System.out.print(currNode.name + " ");
      for (Node neighbor : currNode.neighbors) {
        if (!neighbor.visited) {
          neighbor.visited = true;
          stack.push(neighbor);
        }
      }
    }
  }
}
