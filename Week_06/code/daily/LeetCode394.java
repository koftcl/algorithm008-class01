package daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * 2020/05/27
 */
public class LeetCode394 {
    @Test
    public void test1() {
    }

    public String decodeString(String s) {
//        int status = -1;
//        StringBuilder str = new StringBuilder();
//        for (char c : s.toCharArray()) {
//            int tmp = getStatus(c);
//            if (status < 0) {
//                status = tmp;
//                continue;
//            }
//            if (status == tmp) {
//                str.append(c);
//                continue;
//            }
//            if (status != tmp) {
//                if (status == 0)
//            }
//
//        }
        return null;
    }

    private int getStatus(char c) {
        if (c >= '0' && c <= '9') return 0;
        if (c >= 'a' && c <= 'z') return 1;
        return 0;
    }
}
