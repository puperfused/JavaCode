package com.ds.graph;

import java.util.*;

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if(node1.cost < node2.cost) {
            return -1;
        }
        if(node1.cost > node2.cost) {
            return 1;
        }
        return 0;
    }
}

class GraphShortestPath{
    int V;
    LinkedList<Node> adj[];
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

    void addEdge(int u, int v, int w) {
        adj[u].add(new Node(v,w));
        adj[v].add(new Node(u,w));
    }

    int printDistance(int destinationNode) {
        if(destinationNode > this.V) {
            return Integer.MAX_VALUE;
        }
        return this.dist[destinationNode];
    }

    void shortestPath(int source) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        visited[source] = true;
        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int x = temp.node;
            int w = temp.cost;
            for(int i=0; i<adj[x].size(); i++) {
                int y = adj[x].get(i).node;
                int we = adj[x].get(i).cost;
                if(!visited[y] && dist[y] < we + dist[x]) {
                    dist[y] = we + dist[x];
                    visited[y] = true;
                    pq.add(new Node(y, dist[y]));
                }
            }
        }
    }
}

public class Djikstra {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int edge = scan.nextInt();
        int numNode = scan.nextInt();
        //System.out.println(edge);
        GraphShortestPath graph = new GraphShortestPath(numNode);
        int u, v, w;
        for(int i=0; i<edge; i++) {
            u = scan.nextInt();
            v = scan.nextInt();
            w = scan.nextInt();
            graph.addEdge(u,v,w);
        }
        graph.shortestPath(0);
        int destination = scan.nextInt();
        System.out.println("Shortest distance from node 0 " + graph.printDistance(destination));
    }

}
