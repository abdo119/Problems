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
class Solution {
    static boolean  checkLeftAndRight(TreeNode  left , TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val == right.val)
            return (checkLeftAndRight(left.left,right.right) && checkLeftAndRight(left.right,right.left));
        else 
            return false;
    }
     public boolean isSymmetric(TreeNode root) {
       return checkLeftAndRight(root.left,root.right);
    }
  
}