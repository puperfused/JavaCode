package com.random;

import com.ds.linkedlist.PrintUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution9 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        while(!q.isEmpty()){
            TreeNode top = q.peek();
            q.remove();

            if(top.val == target && top.left==null && top.right==null ){
                // loop till current node's parent value is not leaf and if leaf not equal to target.
                TreeNode temp = parent.get(top);
                if(temp.left == top)
                    temp.left = null;
                else
                    temp.right = null;
                TreeNode currNode = temp;
                while(currNode.val == target && currNode.left == null && currNode.right == null ) {
                    temp = parent.get(currNode);
                    if(temp.left == currNode)
                        temp.left = null;
                    else
                        temp.right = null;
                    currNode = temp;
                }
            }
            if(top!=null && top.left!=null){
                parent.put(top.left, top);
                q.add(top.left);
            }if(top!=null && top.right!=null){
                parent.put(top.right, top);
                q.add(top.right);
            }
        }
        return root;
    }
}

public class DeleteLeaveWithGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        //root.left.left = new TreeNode(2);
        //root.right.left = new TreeNode(2);
        //root.right.right = new TreeNode(4);
        Solution9 solution9 = new Solution9();
        root = solution9.removeLeafNodes(root, 1);
        System.out.println(root.toString());
    }
}
