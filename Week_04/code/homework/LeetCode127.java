package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 2020/05/05
 */
public class LeetCode127 {
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
        if (wordList == null || !wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        int step = 0, start = wordList.size() - 1, end = wordList.indexOf(endWord);
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        HashSet<Integer> visited1 = new HashSet<>();
        HashSet<Integer> visited2 = new HashSet<>();
        queue1.add(start);
        visited1.add(start);
        queue2.add(end);
        visited2.add(end);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();
            while (size1-- > 0) {
                Integer w = queue1.pop();
                String word = wordList.get(w);
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited2.contains(w)) return step + 1;
                    if (visited1.contains(j)) continue;
                    String s = wordList.get(j);
                    if (canConvert(s, word)) {
                        queue1.add(j);
                        visited1.add(j);
                    }
                }
            }
            step++;
            int size2 = queue2.size();
            while (size2-- > 0) {
                Integer w = queue2.pop();
                String word = wordList.get(w);
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited1.contains(w)) return step + 1;
                    if (visited2.contains(j)) continue;
                    String s = wordList.get(j);
                    if (canConvert(s, word)) {
                        queue2.add(j);
                        visited2.add(j);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean canConvert(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
