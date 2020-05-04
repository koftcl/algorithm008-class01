package review;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 2020/05/04
 */
public class LeetCode22 {
    @Test
    public void test1() {
        System.out.println(generateParenthesis(5));
    }

    LinkedList<String> ans = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    public List<String> generateParenthesis(int n) {

        dfs(n, 0, 0);

        return ans;
    }

    /**
     * 回溯法
     * T O(2^2n/(n^1.5))
     * S O(n)
     */
    private void dfs(int max, int left, int right) {
        if (builder.length() == 2 * max) ans.add(builder.toString());

        if (left < max) {
            builder.append('(');
            dfs(max, left + 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (right < left) {
            builder.append(')');
            dfs(max, left, right + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
