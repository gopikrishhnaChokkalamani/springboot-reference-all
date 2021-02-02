package com.mylearning.v1.graph.disjointset;

import com.mylearning.v1.graph.Node;

import java.util.*;
import java.util.stream.Collectors;

public class PrimsAlgorithmImpl {
  
  public static void main(String[] args) {
    List<Node> nodes = new ArrayList<>();
    int i = 0;
    char c = 'A';
    while (i < 7) {
      nodes.add(new Node(i, String.valueOf(c)));
      i++;
      c++;
    }
    PrimsAlgorithmImpl p = new PrimsAlgorithmImpl(nodes);
    p.addUnDirectedWeightedEdge(0, 1, 28);
    p.addUnDirectedWeightedEdge(1, 2, 16);
    p.addUnDirectedWeightedEdge(2, 3, 12);
    p.addUnDirectedWeightedEdge(3, 4, 22);
    p.addUnDirectedWeightedEdge(4, 5, 25);
    p.addUnDirectedWeightedEdge(5, 0, 10);
    p.addUnDirectedWeightedEdge(4, 6, 24);
    p.addUnDirectedWeightedEdge(6, 1, 14);
    p.minimumSpanningTree();
  }
  
  public List<Node> nodes;
  List<UnDirectedEdge> edges = new ArrayList<>();
  
  public PrimsAlgorithmImpl(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  private void addUnDirectedWeightedEdge(int from, int to, int distance) {
    Node fromNode = nodes.get(from);
    Node toNode = nodes.get(to);
    
    fromNode.neighbors.add(toNode);
    toNode.neighbors.add(fromNode);
    
    fromNode.neighborDistanceMap.put(toNode, distance);
    toNode.neighborDistanceMap.put(fromNode, distance);
    
    edges.add(new UnDirectedEdge(fromNode, toNode, distance));
  }
  
  private void minimumSpanningTree() {
    Node startNode = nodes.get(0);
    startNode.distance = 0;
    Queue<Node> queue = new PriorityQueue<>();
    queue.add(startNode);
    while (!queue.isEmpty()) {
      Node currNode = queue.remove();
      currNode.visited = true;
      for (Node neighbor : currNode.neighbors) {
        if (!neighbor.visited) {
          if (currNode.neighborDistanceMap.get(neighbor) < neighbor.distance) {
            neighbor.distance = currNode.neighborDistanceMap.get(neighbor);
            neighbor.parent = currNode;
            queue.add(neighbor);
          }
        }
      }
    }
    
    int cost = 0;
    for (Node node : nodes) {
      System.out.println("First Node - " + (node.parent == null ? null : node.parent.name) + ", Second Node - " + node.name + ", Distance - " + node.distance);
      cost += node.distance;
    }
    System.out.println("Total Cost " + cost);
  }
}