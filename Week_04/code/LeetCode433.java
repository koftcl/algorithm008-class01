import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
 * 2020/05/04
 */
public class LeetCode433 {
    @Test
    public void test1() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int ans = minMutation(start, end, bank);
        Assert.assertEquals(ans, 1);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        String start = "AACCGGTT";
        String end = "AACCGCTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int ans = minMutation(start, end, bank);
        Assert.assertEquals(ans, 2);
        System.out.println(ans);
    }

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();

        queue.add(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.pop();
                if (curr.equals(end)) return level;
                visited.add(curr);
                for (String s : bank) {
                    if (visited.contains(s)) continue;
                    if (diff(curr, s) == 1) {
                        queue.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private int diff(String start, String s) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != s.charAt(i)) {
                if (++count > 1) return count;
            }
        }
        return count;
    }
}
