// Problem1 - Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity : O(n) where n = nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - base condition to check if any of the array is empty
// 2 - root is last element of postorder
// 3 - get index of root from inorder
// 4 - get inorder left, right and postorder left, right array
// 5 - recursion for left and right trees
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
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // 1
    if (inorder.length == 0 || postorder.length == 0) {
      return null;
    }
    
    // 2
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    // 3
    int index = -1;
    for (int i=0; i<inorder.length; i++) {
      if (root.val == inorder[i]) {
        index = i;
      }
    }
    // 4
    int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
    int[] postLeft = Arrays.copyOfRange(postorder, 0, index);

    int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
    int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
    // 5
    root.left = buildTree(inLeft, postLeft);
    root.right = buildTree(inRight, postRight);

    return root;
  }
}

// Problem 2 - Sum Root to Leaf Numbers
// Time Complexity : O(n) where n = nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1 - check if root is null
// 2 - calculate sum
// 3 - check for leaf node
// 4 - recurrsion over left tree and right tree
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
  public int sumNumbers(TreeNode root) {
    return recurr(root, 0);
  }

  private int recurr(TreeNode root, int val) {
    // 1
    if (root == null) {
      return 0;
    }
    
    // 2
    val = val * 10 + root.val;
    // 3
    if (root.left == null && root.right == null) {
      return val;
    }
    
    // 4
    return recurr(root.left, val) + recurr(root.right, val);
  }
}
