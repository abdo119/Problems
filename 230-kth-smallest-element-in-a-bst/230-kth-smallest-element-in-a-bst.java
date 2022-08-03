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
    static List<Integer> res =new ArrayList<>();

    static void sol(TreeNode root, int k) {
        if (root == null){
            return;
        }

        sol(root.left, k);
        res.add(root.val);
        sol(root.right, k);
    }

     public int kthSmallest(TreeNode root, int k) {
        sol(root,k);
        int r = res.get(k-1);
        res.clear();
        return r;
    }
}