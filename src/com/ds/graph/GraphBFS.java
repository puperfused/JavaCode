package com.ds.graph;

import java.util.LinkedList;

class GraphNew {
    int V;
    LinkedList<Integer> adj[];

    GraphNew(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void BFSUtil(int node, boolean visited[]){
        visited[node] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int adjacentNode = queue.poll();
            System.out.println(adjacentNode + " ");
            for(int i=0; i<adj[adjacentNode].size(); i++) {
                int nextNode = adj[adjacentNode].get(i);
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    void BFS(int node){
        boolean visited[] = new boolean[V];
        BFSUtil(node, visited);
        /*for(int i=0; i<V; i++) {
            if(!visited[i]) {
                BFSUtil(i, visited);
            }
        }*/
    }
}
public class GraphBFS {
    public static void main(String args[]) {
        GraphNew g = new GraphNew(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
        System.out.println("BFS Traversal Completed");
    }
}
