class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1: return 1
        n2, n3, n5 = 0, 0, 0
        lst = [1]
        for i in range(1, n):
            c2 = lst[n2] * 2
            c3 = lst[n3] * 3
            c5 = lst[n5] * 5
            curr = min(c2, c3, c5)
            lst.append(curr)
            if curr == c2: n2 += 1
            if curr == c3: n3 += 1
            if curr == c5: n5 += 1
        return curr


if __name__ == '__main__':
    solution = Solution()
    print(solution.nthUglyNumber(10))
