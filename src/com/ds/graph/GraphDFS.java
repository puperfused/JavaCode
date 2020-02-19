package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {

    int V;
    LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[V];

        for(int i=0; i<V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void DFSUtil(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println(node + " ");
        Iterator<Integer> itr = adj[node].listIterator();
        while(itr.hasNext()) {
            int adjacentNode = itr.next();
            if(!visited[adjacentNode]) {
                DFSUtil(adjacentNode, visited);
            }
        }
    }

    void DFS() {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }

}

public class GraphDFS {
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS();
        System.out.println("Traversal Completed ");
    }
}
