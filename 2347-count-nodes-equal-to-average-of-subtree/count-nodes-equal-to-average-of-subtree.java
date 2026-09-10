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
    private int result;
    private Pair<Integer,Integer> solve(TreeNode root){
        if(root == null){
            return new Pair<>(0,0);
        }
        Pair<Integer,Integer> ls = solve(root.left);
        Pair<Integer,Integer> rs = solve(root.right);

        int leftsum = ls.getKey();
        int leftcount = ls.getValue();

        int rightsum = rs.getKey();
        int rightcount = rs.getValue();

        int sum = leftsum + rightsum + root.val;
        int count = leftcount + rightcount + 1;

        int avg = sum / count;

        if(avg == root.val){
            result++;
        }
        return new Pair<>(sum,count);
    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;

        solve(root);
        return result;
    }
}