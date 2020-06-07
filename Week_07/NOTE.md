# 并查集基本操作
1. makeSet(s): 建立一一个新的并查集，其中包含s个单元素集合。
2. unionSet(x, y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
3. find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

# 心得
关注点在对象之间的连接

# 代码模板
```java
class UnionFind { 
    private int count = 0; 
    private int[] parent; 
    public UnionFind(int n) { 
        count = n; 
        parent = new int[n]; 
        for (int i = 0; i < n; i++) { 
                parent[i] = i;
        }
    } 
    public int find(int p) { 
        while (p != parent[p]) { 
            // 路径优化
            parent[p] = parent[parent[p]];
            p = parent[p]; 
        }
        return p; 
    }

    public void union(int p, int q) { 
        int rootP = find(p); 
        int rootQ = find(q); 
        if (rootP == rootQ) return; 
        parent[rootP] = rootQ; 
        count--;
    }
}
```

```python
def init(p): 
        # for i = 0 .. n: p[i] = i; 
        p = [i for i in range(n)] 
 
def union(self, p, i, j): 
        p1 = self.parent(p, i) 
        p2 = self.parent(p, j) 
        p[p1] = p2 
 
def parent(self, p, i): 
        root = i
        while p[root] != root: 
                root = p[root] 
        while p[i] != i: # 路径压缩 ?
                x = i; i = p[i]; p[x] = root 
        return roo
```

# 字典树Trie

# 代码模板
[模板链接](https://shimo.im/docs/Pk6vPY3HJ9hKkh33)
```python
class Trie(object):
  
        def __init__(self): 
                self.root = {} 
                self.end_of_word = "#" 
 
        def insert(self, word): 
                node = self.root 
                for char in word: 
                        node = node.setdefault(char, {}) 
                node[self.end_of_word] = self.end_of_word 
 
        def search(self, word): 
                node = self.root 
                for char in word: 
                        if char not in node: 
                                return False 
                        node = node[char] 
                return self.end_of_word in node 
 
        def startsWith(self, prefix): 
                node = self.root 
                for char in prefix: 
                        if char not in node: 
                                return False 
                        node = node[char] 
                return True
```

```java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }


    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

# 实战
## 单词搜索2
1. DFS
    1. T O(N * m * m * 4^k)
2. Trie
    1. T Om * m * 4 ^ k

# 高级搜索
1. 剪枝
2. 双向BFS
3. 启发式搜索(A*)

# 初级搜索
1. 朴素搜索
2. 优化方式： 
    1. 不重复
        1. fib
    2. 剪枝
        1. 生成括号问题
3. 搜索方向： 
    1. BFS
    2. DFS

# 回溯
1. 回溯法采用试错的思想，它尝试分步的去解决一个问题。 在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
2. 回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况:
    1. 找到一个可能存在的正确的答案
    2. 在尝试了所有可能的分步方法后宣告该问题没有答案
    3. 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

# 启发式搜索

1. 启发式函数: h(n), 它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数，也可以认为是从结点n的目标结点路径的估计成本。
2. 启发式函数是一种告知搜索方向的方法。它提供了-种明智的方法来猜测哪个邻居结点会导向一个目标。

# 高级树、AVL树和红黑树
# 树列表

1. 二叉树
2. 平衡树
    1. 2-3 tree
    2. AA tree
    3. AVL tree
    4. B-tree - lvl 1
    5. Red-black tree
    6. Scapegoat tree
    7. Splay tree
    8. Treap - lvl 2
    9. Weight-balanced tree
3. 近似平衡树
4. 二三树
5. B树、 B+树、B-树

# 二叉树遍历
1. DFS
    1. preorder 根 左 右
    2. inorder 左 根 右
    3. postorder 左 右 根
2. BFS

# 二叉搜索树

1. 二叉搜索树，也称二叉搜索树、有序叉树 (Ordered Binary Tree)、排序二叉树(Sorted BinaryTree) ,是指一棵空树或者具有下列性质的二叉树:
    1. 左子树上所有结点的值均小于它的根结点的值;
    2. 右子树上所有结点的值均大于它的根结点的值;
    3. 以此类推:左、右子树也分别为二叉查找树。(这就是 重复性! )
2. 中序遍历: 升序排列

# 保证性能的关键
1. 保证维维度! -> 左右子树结点平衡(recursively)
2. Balanced
3. [文档](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

# AVL树

1. 发明者G. M. Adelson-Velsky和Evgenii Landis
2. Balance Factor (平衡因子)
    1. 是它的左子树的高度减去它的右子树的高度(有时相反)。
    2. balance factor={-1, 0, 1}
3. 通过旋转操作来进行平衡(四种)
4. [文档](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

# 旋转操作
1. 左旋
2. 右旋
3. 左右旋
4. 右左旋

# 红黑树

是一种近似平衡的二叉搜索树(Binary SearchTree) ,它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树:

1. 每个结点要么是红色，要么是黑色
2. 根结点是黑色
3. 每个叶结点(NIL结点， 空结点)是黑色的。
4. 不能有相邻接的两个红色结点
5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。

## 对比 AVL 与 红黑树

1. AVL trees provide *faster lookups* than Red Black Trees because they are *more strictly balanced*.
2. Red Black Trees provide *faster insertion and removal* operations than AVLtrees as fewer rotations are done due to relatively relaxed balancing.
3. AVLtrees store balance *factors or heights* with each node, thus requires storage for an integer per nodewhereas Red Black Tree requires only 1 bit of information per node.
4. Red Black Trees are used in most of the *language libraries like map, multimap, multisetin C++* whereas AVL trees are used in *databases* where faster retrievals are required.
