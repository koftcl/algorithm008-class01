package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 单词接龙 II
 * https://leetcode-cn.com/problems/word-ladder-ii/
 * 2020/05/08
 */
public class LeetCode126 {

    @Test
    public void test1() {
        String start = "hot";
        String end = "dog";
        List<String> wordList = Arrays.asList("hot","dog");
        List<List<String>> ladders = findLadders(start, end, new ArrayList<>(wordList));
        sout(ladders);
    }

    private void sout(List<List<String>> ladders) {
        for (List<String> ladder : ladders) {
            for (String s : ladder) {
                System.out.print(s + ' ');
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> ladders = findLadders(start, end, new ArrayList<>(wordList));
        sout(ladders);
    }

    @Test
    public void test3() {
        String start = "red";
        String end = "tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        List<List<String>> ladders = findLadders(start, end, new ArrayList<>(wordList));
        sout(ladders);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        if (!wordList.contains(endWord)) return new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        LinkedList<List<String>> queue = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();
        LinkedList<String> begin = new LinkedList<>();

        visited.add(beginWord);
        begin.add(beginWord);
        queue.add(begin);

        boolean flag = false;

        while (!queue.isEmpty()) {

            LinkedList<List<String>> tmp = new LinkedList<>();
            for (List<String> words : queue) {
                String word = words.get(words.size() - 1);
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String tar = String.valueOf(chars);
                        if (old == c) continue;

                        if (tar.equals(endWord)) {
                            flag = true;
                            LinkedList<String> list = new LinkedList<>(words);
                            list.add(tar);
                            ans.add(list);
                            visited.add(tar);
                            continue;
                        }

                        if (!visited.contains(tar) && wordSet.contains(tar)) {
                            LinkedList<String> list = new LinkedList<>(words);
                            list.add(tar);
                            tmp.add(list);
                            visited.add(tar);
                        }
                        chars[i] = old;
                    }
                }
            }

            if (flag) {
                return ans;
            }

            queue = tmp;
        }
        return new LinkedList<>();
    }
}
