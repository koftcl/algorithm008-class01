package homework;

import org.junit.Test;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 2020/06/06
 */
public class LeetCode208_2 {
    @Test
    public void test1() {
        Trie trie = new Trie();

        trie.insert("apple");
        // 返回 true
        System.out.println(trie.search("apple"));
        // 返回 false
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));
    }

    class Trie {
        private Trie[] next;
        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            this.next = new Trie[26];
            this.isEnd = false;
        }

        /** Inserts a word into the trie. */
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

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int n = c - 'a';
                node = node.next[n];
                if (node == null) return null;
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }
    }
}
