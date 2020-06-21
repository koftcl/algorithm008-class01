学习笔记

# 63. 不同路径 II
状态转移方程
当obstacleGrid[j][i] == 1 dp[j][i] = 0
当obstacleGrid[j][i] == 0 时分2种情况
1. 自底向上递推
dp[j][i] = dp[j - 1][i] + dp[j][i - 1]
2. 自顶向下递推
dp[j][i] = dp[j + 1][i] + dp[j][i + 1]