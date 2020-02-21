package com.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GraphNode {
    int V;
    List<List<Integer>> adj;

    GraphNode(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for(int i=0; i<V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    boolean isCyclicUtil(int node, boolean visited[], boolean recStack[]) {
        if(recStack[node]) {
            return true;
        }
        if(visited[node]) {
            return false;
        }
        visited[node] = true;
        recStack[node] = true;
        List<Integer> adjacentNodes = adj.get(node);
        for(Integer itr: adjacentNodes) {
            if(isCyclicUtil(itr, visited, recStack)) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }

    boolean isCyclicGraph() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if(isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
}
public class FindCycleInDirectedGraph {
    public static void main(String args[]) {
        GraphNode graph = new GraphNode(4);
        graph.addEdge(0, 1);
        //graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        //graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        //graph.addEdge(3, 3);
        if(graph.isCyclicGraph()) {
            System.out.println("Given Graph contains a cycle");
        } else {
            System.out.println("Given Graph does not contain a cycle");
        }
    }
}
