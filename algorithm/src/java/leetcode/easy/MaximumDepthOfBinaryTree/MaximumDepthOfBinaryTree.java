package leetcode.easy.MaximumDepthOfBinaryTree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return num(root, 1,0);
    }

    private int num (TreeNode treeNode, int depth, int max) {
        if (treeNode.left == null && treeNode.right == null) {
            return depth > max ? depth : max;
        }
        if (treeNode.left != null) {
            max = num(treeNode.left, depth+1, max);
        }
        if (treeNode.right != null) {
            max = num(treeNode.right, depth+1, max);
        }
        return max;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
