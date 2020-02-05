package com.ds.binarytree;

/**
 *  Program to find the lowest common ancestor of two nodes in binary search tree , doing random changes
 */
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
    Node root;
}

public class Lca {

    static Node lca(Node root, int a, int b){
        if(root == null){
            return null;
        }
        if(a < root.data && b < root.data){
            return lca(root.left, a, b);
        }
        if(a > root.data && b > root.data){
            return lca(root.right, a, b);
        }
        return root;
    }

    public static void main(String args[]){
        BinarySearchTree bt = new BinarySearchTree();
        bt.root = new Node(20);
        bt.root.left = new Node(8);
        bt.root.right = new Node(22);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(12);
        bt.root.left.right.left = new Node(10);
        bt.root.left.right.right = new Node(14);
        Node answer = lca(bt.root, 10, 22);
        System.out.println("The lca is " + answer.data);
    }

}
