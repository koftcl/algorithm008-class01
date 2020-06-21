package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 2020/06/21
 */
public class LeetCode387 {

    @Test
    public void test1() {
        int i = firstUniqChar("");
        Assert.assertEquals(i, -1);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = firstUniqChar("leetcode");
        Assert.assertEquals(i, 0);
        System.out.println(i);
    }

    @Test
    public void test3() {
        int i = firstUniqChar("ssslllc");
        Assert.assertEquals(i, 6);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (counter.containsKey(c)) counter.put(c, counter.get(c) + 1);
            else counter.put(c, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counter.get(c) == 1) return i;
        }

        return -1;
    }
}
