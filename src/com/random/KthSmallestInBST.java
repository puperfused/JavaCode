import java.util.*;

/**
 *  Find the kth smallest in BST in O(1) extra space
 *  Use Moris traversal / threaded binary tree concept
 */

 class Node {
     int key;
     Node left;
     Node right;

     Node(int key) {
         this.key = key;
         this.left = null;
         this.right = null;
     }
 }

 class Solution {
    public static int findKthSmallest(Node root, int k) {
        Node current = root;
        int count = 0;
        int minValue = 0;
        while(current != null) {
            if(current.left == null) {
                count++;
                if(count == k) {
                    minValue = current.key;
                }
                current = current.right;
            } else {
                Node pre = current.left;
                while(pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if(pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    count++;
                    if(count == k) {
                        minValue = current.key;
                    }
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return minValue;
    }
 }

 class KthSmallestInBST {
     public static void main(String args[]) {
         Node root = new Node(50);
         root.left = new Node(30);
         root.right = new Node(70);
         root.left.left = new Node(20);
         root.left.right = new Node(40);
         root.right.left = new Node(60);
         root.right.right = new Node(80);
         int k = 7;
         int ans = Solution.findKthSmallest(root, k);
         System.out.println("Kth smallest element is " + ans);
     }
 }