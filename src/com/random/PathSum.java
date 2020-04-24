package com.random;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution3 {
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) {
            if(sum == 0) {
                return true;
            }
            return false;
        }

        if(hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;
    }
}

public class PathSum {
    public static void main(String args[]) {
        Solution3 solution3 = new Solution3();
        int sum = 20;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(8);
        //root.left.left = new TreeNode(11);
        boolean ans = solution3.hasPathSum(root, 1);
        System.out.println(ans);
    }
}
