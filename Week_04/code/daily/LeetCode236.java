package daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 2020/05/10
 */
public class LeetCode236 {
    @Test
    public void test1() {
        TreeNode root = deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode treeNode = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(treeNode.val);
    }
    @Test
    public void test2() {
        TreeNode root = deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode treeNode = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list = new LinkedList<>();
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (node.val == p.val || node.val == q.val) return node;

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        if (left != null && right != null) return node;
        if (left != null) return left;
        return right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deserialize(String data) {
        if (data.length() < 3) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(nodes[0]));
        helper(root, 0, nodes);

        return root;
    }

    private void helper(TreeNode node, int i, String[] nodes) {
        // terminator
        if (i > nodes.length) return;

        // drill down
        TreeNode left = child(nodes, i, 1);
        if (left != null) {
            node.left = left;
            helper(left, i * 2 + 1, nodes);
        }
        TreeNode right = child(nodes, i, 2);
        if (right != null) {
            node.right = right;
            helper(right, i * 2 + 2, nodes);
        }
    }

    private TreeNode child(String[] nodes, int i, int index) {
        if (i * 2 + 1 >= nodes.length) return null;
        String node = nodes[2 * i + index];
        if ("null".equals(node)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(node));
    }

}
