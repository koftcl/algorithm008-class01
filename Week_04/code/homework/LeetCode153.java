package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 2020/05/10
 */
public class LeetCode153 {
    @Test
    public void test1() {
        Assert.assertEquals(findMin(new int[]{4,5,6,7,0,1,2}), 0);
    }

    @Test
    public void test2() {
        Assert.assertEquals(findMin(new int[]{2,1}), 1);
    }

    public int findMin(int[] nums) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] < nums[(mid + len - 1) % len]) return nums[mid];
            if (nums[mid] >= nums[lo] && nums[lo] > nums[hi])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return nums[0];
    }
}
