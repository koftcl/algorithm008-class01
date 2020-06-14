package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 493. 翻转对
 * https://leetcode-cn.com/problems/reverse-pairs/
 * 2020/06/14
 */
public class LeetCode493 {
    @Test
    public void test1() {
        int ans = reversePairs(new int[]{1, 3, 2, 3, 1});
        Assert.assertEquals(ans, 2);
        System.out.println(ans);
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;

        int mid = (hi + lo) >> 1;
        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);

        int i = lo, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[hi - lo + 1];

        while (i <= mid) {
            while (p <= hi && nums[i] > 2L * nums[p]) p++;
            count += p - (mid + 1);

            while (j <= hi && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= hi) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, lo, merge.length);

        return count;
    }
}
