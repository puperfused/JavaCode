package com.random;

class Solution10 {
    public static TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] res = new TreeNode[]{null, null};
        if(root == null) {
            return res;
        }
        // res[1] refers to the subtree with node values greater than target and minimum structure deformation
        // res[0] refers to the subtree with node values less than or equal to target
        if(root.val > target) {    // target less than root, so it lies in left subtree, hence we can copy the root with right subtree as a whole in res[1]
            TreeNode[] leftSide = splitBST(root.left, target);
            root.left = leftSide[1];
            res[0] = leftSide[0];
            res[1] = root;
        } else {                // target greater than root, so it exist in right subtree with high probability.
            TreeNode[] rightSide = splitBST(root.right, target);
            root.right = rightSide[0];
            res[1] = rightSide[1];
            res[0] = root;
        }
        return res;
    }

}

public class SplitBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Solution10 solution10 = new Solution10();
        TreeNode[] ans = solution10.splitBST(root, 2);
        System.out.println(ans[0].val + " " + ans[1].val);
    }
}
