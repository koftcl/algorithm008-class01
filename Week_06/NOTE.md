# 动态规划
1. [定义](https://en.wikipedia.org/wiki/Dynamic_programming)
2. 与分支的区别： 对子问题的结果进行比较，选择最优的一个或几个
3. 存在最优子结构
4. 共性： 找到重复子问题
5. 差异性： 最优子结构、中途可以淘汰次优解

# 解题心得
## lc1143
1. 关注状态空间
2. 状态空间中状态的迁移抽象成状态转移方程
3. 2维度结构需要选择，而1维结构不需要
4. 创建dp数组时，python3 使用 [[0] * m] * n 会造成拷贝问题，所以必须用[[0] * m for _ in range(n)]


# 动态规划3步
1. 子问题，找重复性
2. 状态定义（基本功）
3. DP方程（竞赛难度体现在这里）

# 刻意训练题目

1. 中等
    1. https://leetcode-cn.com/problems/minimum-path-sum/
    2. https://leetcode-cn.com/problems/decode-ways
    3. https://leetcode-cn.com/problems/maximal-square/
    4. https://leetcode-cn.com/problems/task-scheduler/
    5. https://leetcode-cn.com/problems/palindromic-substrings/
2. 困难
    1. https://leetcode-cn.com/problems/longest-valid-parentheses/
    2. https://leetcode-cn.com/problems/edit-distance/
    3. https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
    4. https://leetcode-cn.com/problems/frog-jump/
    5. https://leetcode-cn.com/problems/split-array-largest-sum
    6. https://leetcode-cn.com/problems/student-attendance-record-ii/
    7. https://leetcode-cn.com/problems/minimum-window-substring/
    8. https://leetcode-cn.com/problems/burst-balloons/
3. 实战题目
    1. https://leetcode-cn.com/problems/house-robber/
    2. https://leetcode-cn.com/problems/house-robber-ii/description/
    3. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
    4. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
    5. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
    6. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    7. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
    8. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    9. https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
4. 高级 DP 实战题目
    1. https://leetcode-cn.com/problems/perfect-squares/
    2. https://leetcode-cn.com/problems/edit-distance/ （重点）
    3. https://leetcode-cn.com/problems/jump-game/
    4. https://leetcode-cn.com/problems/jump-game-ii/
    5. https://leetcode-cn.com/problems/unique-paths/
    6. https://leetcode-cn.com/problems/unique-paths-ii/
    7. https://leetcode-cn.com/problems/unique-paths-iii/
    8. https://leetcode-cn.com/problems/coin-change/
    9. https://leetcode-cn.com/problems/coin-change-2/