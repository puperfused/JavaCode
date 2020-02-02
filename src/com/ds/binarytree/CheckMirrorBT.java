package com.ds.binarytree;

import com.ds.binarytree.Node;


public class CheckMirrorBT {

    static boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null && root1.data == root2.data) {
            return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
        }
        return false;
    }

    static boolean isSymmetric(Node root1, Node root2){
        return isMirror(root1, root2);
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        //root.left.left = new Node(3);
        root.left.right = new Node(3);
        //root.right.left = new Node(4);
        root.right.right = new Node(3);
        boolean output = isSymmetric(root,root);
        System.out.println("isMirror Status " + output);
    }

}
