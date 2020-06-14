package homework;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 212. 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 * 2020/06/07
 */
public class LeetCode212 {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = board.length;
        LinkedList<String> ans = new LinkedList<>();
        if (n == 0) return ans;

        int m = board[0].length;

        int[] x_ori = new int[]{0, 1, -1, 0, 0};
        int[] y_ori = new int[]{0, 0, 0, 1, -1};

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                Trie node  = trie;
                for (int k = 0; k < 5; k++) {
                    char curr = board[j + y_ori[k]][i + x_ori[k]];
//                    trie.next[curr - 'a']

                }
            }
        }
        return ans;
    }

    public class Trie{

        private Trie[] next;
        private boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            Trie node = this;
            for (char c : word.toCharArray()) {
                int n = c - 'a';
                if (node.next[n] == null) node.next[n] = new Trie();
                node = node.next[n];
            }
            node.isEnd = true;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (char c : prefix.toCharArray()) {
                int n = c - 'a';
                if (node.next[n] == null) return null;
                node = node.next[n];
            }
            return node;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startWith(String word) {
            Trie node = searchPrefix(word);
            return node != null;
        }
    }
}
