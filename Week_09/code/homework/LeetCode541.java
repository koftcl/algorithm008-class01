package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 2020/06/21
 */
public class LeetCode541 {

    @Test
    public void test1() {
        String s = reverseStr("abcdefg", 2);
        Assert.assertEquals(s, "bacdfeg");
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int m = Math.min(n, i + k);
            int lo = i, hi = m - 1;
            while (lo < hi) {
                char tmp = chars[lo];
                chars[lo++] = chars[hi];
                chars[hi--] = tmp;
            }
        }
        return new String(chars);
    }
}
