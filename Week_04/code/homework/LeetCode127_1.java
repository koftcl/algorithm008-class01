package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 2020/05/05
 */
public class LeetCode127_1 {
    @Test
    public void test1() {
        String start = "hot";
        String end = "dog";
        List<String> wordList = Arrays.asList("hot","dog");
        int ans = ladderLength(start, end, new ArrayList<>(wordList));
        Assert.assertEquals(ans, 0);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int ans = ladderLength(start, end, new ArrayList<>(wordList));
        Assert.assertEquals(ans, 5);
        System.out.println(ans);
    }

    /**
     * BFS
     * T O(n)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        int step = 1;
        HashSet<String> visited = new HashSet<>();

        startSet.add(beginWord);
        endSet.add(endWord);

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                HashSet<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }

            HashSet<String> tmp = new HashSet<>();
            for (String word : startSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String tar = String.valueOf(chars);

                        if (endSet.contains(tar)) return step + 1;

                        if (!visited.contains(tar) && wordSet.contains(tar)) {
                            tmp.add(tar);
                            visited.add(tar);
                        }
                        chars[i] = old;
                    }
                }
            }

            startSet = tmp;
            step++;
        }
        return 0;
    }
}
