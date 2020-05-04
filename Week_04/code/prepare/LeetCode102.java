package prepare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * 2020/05/03
 */
public class LeetCode102 {
    @Test
    public void name() {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        dfs(ans, root, 0);

        return ans;
    }

    /**
     * 递归 DFS
     * T O(n)
     * S O(n)
     */
    private void dfs(ArrayList<List<Integer>> ans, TreeNode node, int level) {
        // terminator
        if (node == null) return;

        // process
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(node.val);

        // drill down
        dfs(ans, node.left, level + 1);
        dfs(ans, node.right, level + 1);

        // reverse
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
