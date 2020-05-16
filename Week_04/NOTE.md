# 特性
1. 对象
    1. 树
    2. 图
2. 目标
    1. 都要访问一次
    2. 仅访问一次
3. 顺序
    1. dfs
    2. bfs
    3. pfs

## dfs
```python
def dfs(node):
    if node in vistied:
        # already visited
        return
    
    visited.add(node)
    
    # process current node
    # ... # logic here
    dfs(node.left)
    dfs(node.right)
```

```python
visited = set()

def dfs(node, visited):
    visited.add(node)
    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

## bfs
```python
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```

# 实现

# 定义
贪心算法 Greedy
每一步都选择局部最优，从而实现全局最优的算法

# 与动归的区别
1. 贪心： 当下最优判断
2. 回溯： 能够回退
3. 动态规划： 最优判断+回退

# 用途
1. 最优化问题
2. 工程中，贪心算法通常不能获得最优结果

# 场景
1. 最优子结构 问题能够分解成子问题来解决，子问题的最优解能够递推到最终问题的最优解。
2. 与动态规划相比，贪心算法不能回退。动态规划择会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

# 特点
1. 高效
2. 通常结果接近最优

# 实战题
Coin Change 特别版本
https://leetcode-cn.com/problems/coin-change/
适合使用贪心算法

# 技巧
1. 寻找切入点
    1. 从前往后
    2. 从后往前
    3. 从中间的某个点
    
# 二分查找前提
1. 有序
2. 存在上下界 bounded *有特殊形态*
3. 能通过索引访问 index accessible

# 代码模板
```binary search
left, right = 0, len(array) - 1 
while left <= right: 
  mid = (left + right) / 2 
  if array[mid] == target: 
    # find the target!! 
    break or return result 
  elif array[mid] < target: 
    left = mid + 1 
  else: 
    right = mid - 1
```

# 四步做题法
1. 审题
2. 遍历所有解法
    1. 算出，时间复杂度和空间复杂度
    2. 找到最优解
3. 写测试用例
    1. 正常测试
    2. 边界条件
    3. 极端情况