package com.ds.binarytree;

import com.ds.binarytree.Lca.*;
import com.ds.binarytree.Lca.*;

/**
 * Convert the binary tree to doubly linked list, left becomes prev and right becomes next node of current
 */

class LinkList extends BinarySearchTree{
    //To keep the reference to the head node of the double linked list
    static Node head;
    //
    static Node prev = null;
}

public class ConvertTreeToDLL {

    static void convertTreeToDLL(Node root){
        if(root == null){
            return;
        }
        convertTreeToDLL(root.left);
        if(LinkList.prev == null){
            LinkList.head = root;
        } else{
            root.left = LinkList.prev;
            LinkList.prev.right = root;
        }
        LinkList.prev = root;
        convertTreeToDLL(root.right);
    }
    public static void main(String args[]) {
        LinkList list = new LinkList();
        list.root = new Node(10);
        list.root.left = new Node(12);
        list.root.right = new Node(15);
        list.root.left.left = new Node(25);
        list.root.left.right = new Node(30);
        list.root.right.left = new Node(36);
        convertTreeToDLL(list.root);
        while(LinkList.head!=null){
            System.out.println(LinkList.head.data + " ");
            LinkList.head =  LinkList.head.right;
        }

    }
}
