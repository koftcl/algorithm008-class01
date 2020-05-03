# 每日一题
## day17
1. https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
2. https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
3. https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

# 综述
1. 针对重复性
    1. 最近 构造分解
        1. 分治
        2. 回溯
    2. 最优 动态规划
    3. 本质是递归
2. 递归状态树
    1. ![290725c3a4232598d2dd68c51698b492.png](en-resource://database/3608:1) 

# 分治
```python
def divide_conquer(problem, param1, param2, ...): 
    # recursion terminator 
    if problem is None: 
    print_result 
    return 

    # prepare data 
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data) 

    # conquer subproblems 
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
    …

    # process and generate the final result 
    result = process_result(subresult1, subresult2, subresult3, …)

    # revert the current level states
```

# 回溯
1. 下探所有可能
2. 判断是否错误
3. 判断错误就回溯
4. 没错误就继续直到终点

## 实战
### Pow(x,n)
1. 暴力
2. 分治
3. 牛顿迭代法

### 子集
