package com.mylearning.v1.graph.search;

import com.mylearning.v1.graph.GraphUtility;
import com.mylearning.v1.graph.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BFSImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = GraphUtility.initializeNodes(7);
    BFSImpl b = new BFSImpl(nodes);
    GraphUtility.initializeUnDirectedUnWeightedEdges(nodes);
    b.bfs();
  }
  
  private final List<Node> nodes;
  
  public BFSImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void bfs() {
    for (Node node : nodes) {
      if (!node.visited) {
        bfs(node);
      }
    }
  }
  
  private void bfs(Node node) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      currNode.visited = true;
      System.out.print(currNode.name + " ");
      for (Node neighbor : currNode.neighbors) {
        if (!neighbor.visited) {
          neighbor.visited = true;
          queue.add(neighbor);
        }
      }
    }
  }
}
