package com.mylearning.v1.graph.disjointset;

import com.mylearning.v1.graph.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class KruskalAlgorithmImpl {

  public static void main(String[] args) {
    List<Node> nodes = new ArrayList<>();
    int i = 0;
    char c = 'A';
    while (i < 7) {
      nodes.add(new Node(i, String.valueOf(c)));
      i++;
    }
    KruskalAlgorithmImpl k = new KruskalAlgorithmImpl(nodes);
    k.addUnDirectedWeightedEdge(0, 1, 28);
    k.addUnDirectedWeightedEdge(1, 2, 16);
    k.addUnDirectedWeightedEdge(2, 3, 12);
    k.addUnDirectedWeightedEdge(3, 4, 22);
    k.addUnDirectedWeightedEdge(4, 5, 25);
    k.addUnDirectedWeightedEdge(5, 0, 10);
    k.addUnDirectedWeightedEdge(4, 6, 24);
    k.addUnDirectedWeightedEdge(6, 1, 14);
    k.kruskalAlgorithm();
  }

  public List<Node> nodes;
  List<UnDirectedEdge> edges = new ArrayList<>();

  public KruskalAlgorithmImpl(List<Node> nodes) {
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

  private void kruskalAlgorithm() {
    DisJointSet.makeSet(nodes);
    List<UnDirectedEdge> sortedEdges = edges.stream().sorted(Comparator.comparingInt(o -> o.distance)).collect(Collectors.toList());
    int cost = 0;
    DisJointSet set = null;
    List<UnDirectedEdge> mst = new LinkedList<>();
    for (UnDirectedEdge edge : sortedEdges) {
      Node firstNode = edge.fromNode;
      Node secondNode = edge.toNode;
      if (!DisJointSet.findSet(firstNode).equals(DisJointSet.findSet(secondNode))) {
       set = DisJointSet.union(firstNode, secondNode);
       cost += edge.distance;
       set.print();
       System.out.println("Cost " + cost);
       mst.add(new UnDirectedEdge(firstNode, secondNode, edge.distance));
       System.out.println();
      } else {
        System.out.println((firstNode.index + 1)  + " and " + (secondNode.index + 1) + " skipped to avoid cycle Formation ");
        System.out.println();
      }
    }
    System.out.println("Minimum Spanning Tree");
    for (UnDirectedEdge edge : mst) {
      System.out.print("First Node - " + (edge.fromNode.index+1) + ", Second Node - " + (edge.toNode.index+1) + ", Distance - " + edge.distance);
      System.out.println();
    }
    System.out.print("Final Set - ");
    set.print();
    System.out.println("Total Cost -  " + cost);
  }
}