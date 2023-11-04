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

    private void inOrderHelper(TreeNode node, List<Integer> list) {
        if (node != null) {
            //populate left side
            inOrderHelper(node.left, list);
            //root
            list.add(node.val);
            //right side
            inOrderHelper(node.right, list);
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        //traverse the tree and make it a list -> small...root...large
        inOrderHelper(root, list);
        //now 2 pointers approach in the list
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
        
    }
}