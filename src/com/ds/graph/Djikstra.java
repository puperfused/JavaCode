package com.ds.graph;

import java.util.LinkedList;
import java.util.Scanner;

class GraphShortestPath{
    int V;
    LinkedList<Integer> adj[];
    int dist[];
    boolean visited[];

    GraphShortestPath(int V) {
        this.V = V;
        dist = new int[V];
        for(int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0]=0;
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    int printDistance(int destinationNode) {
        if(destinationNode > this.V) {
            return Integer.MAX_VALUE;
        }
        return this.dist[destinationNode];
    }

     int shortestPathUtil(){

    }

    int shortestPath(int source) {

    }
}

public class Djikstra {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int edge = scan.nextInt();
        GraphShortestPath graph = new GraphShortestPath(edge);
        int u, v;
        for(int i=0; i<edge; i++) {
            u = scan.nextInt();
            v = scan.nextInt();
            graph.addEdge(u,v);
        }
        int result = graph.shortestPath(0);
        int destination = scan.nextInt();
        System.out.println("Shortest distance from node 0 " + graph.printDistance(destination));
    }

}
