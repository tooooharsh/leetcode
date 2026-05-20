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
    public int rob(TreeNode root) {
        int[] options = helper(root);
        return Math.max(options[0], options[1]); //0 for rob, 1 for skip  
    }

    private int[] helper(TreeNode root){
        if(root == null) return new int[2];
        int[] left  = helper(root.left);
        int[] right  = helper(root.right);
        int[] options = new int[2];

       // rob case = rob current + skip left and right of child
        options[0] = root.val + left[1]+ right[1];
       // skip case = skip current + rob max of left and max of right 
        options[1] = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        return options;
    }
}