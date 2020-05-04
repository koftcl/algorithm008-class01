import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * 2020/05/03
 */
public class LeetCode102_1 {
    @Test
    public void name() {

    }

    /**
     * BFS
     * T O(n)
     * S O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        LinkedList<Integer> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();

            if (node == null) {
                ans.add(list);
                list = new LinkedList<>();
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }

            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return ans;
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
