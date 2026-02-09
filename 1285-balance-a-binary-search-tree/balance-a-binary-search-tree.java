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
    public void inorder(TreeNode root,ArrayList<Integer> vec){
        if(root == null) return;
        inorder(root.left,vec);
        vec.add(root.val);
        inorder(root.right,vec);
    }
    public TreeNode solve(int l,int r,ArrayList<Integer> vec){
        if(l > r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(vec.get(mid));
        root.left = solve(l,mid-1,vec);
        root.right = solve(mid+1,r,vec);
        return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> vec = new ArrayList<>();
        inorder(root,vec);
        int l = 0;
        int r = vec.size()-1;
        return solve(l,r,vec);
    }
}