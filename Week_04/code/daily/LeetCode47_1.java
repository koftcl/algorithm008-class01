package daily;

import org.junit.Test;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * 2020/05/24
 */
public class LeetCode47_1 {
    @Test
    public void test1() {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> ans = new LinkedList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return ans;

        Arrays.sort(nums);
        this.nums = nums;

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(visited, list);

        return ans;
    }

    private void dfs(Set<Integer> visited, LinkedList<Integer> list) {
        if (nums.length == list.size()) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1)) continue;
            if (visited.add(i)) {
                list.add(nums[i]);
                dfs(visited, list);
                list.pollLast();
                visited.remove(i);
            }
        }

    }
}
