package prepare;

import org.junit.Test;

import java.util.*;

/**
 * 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * 2020/05/04
 */
public class LeetCode515 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(-1);

        System.out.println(largestValues(root));
    }

    ArrayList<Integer> ans = new ArrayList<>();

    /**
     * DFS
     * T O(n)
     * S O(logn)
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (ans.size() < level + 1) ans.add(node.val);
        else ans.set(level, Math.max(ans.get(level), node.val));

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    /**
     * BFS
     * T O(n)
     * S O(logn)
     */
    public List<Integer> largestValues1(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(max);
            max = Integer.MIN_VALUE;
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
