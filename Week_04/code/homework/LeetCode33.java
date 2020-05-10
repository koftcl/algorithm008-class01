package homework;

import org.junit.Assert;
import org.junit.Test;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 2020/05/10
 */
public class LeetCode33 {
    @Test
    public void test1() {
        Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 0), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(search(new int[]{3,1}, 1), 1);
    }

    /**
     * 二分查找
     * T O(logn)
     * S O(1)
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = -1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (target <= nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}
