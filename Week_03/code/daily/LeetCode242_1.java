package daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * 2020/05/03
 */
public class LeetCode242_1 {
    @Test
    public void name() {
        System.out.println(this.isAnagram("anagram", "nagaram"));
    }

    /**
     * 排序
     * T O(nlogn)
     * S O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] a1 = t.toCharArray();
        Arrays.sort(a1);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a1[i]) return false;
        }
        return true;
    }
}
