import sys
input = lambda: sys.stdin.readline()

def sol():
    n = int(input())
    line = [list(map(int, input().split())) for _ in range(n)]
    line.sort()
    dp = [0] * n
    dp[0] = 1
    for i in range(1, n):
        for j in range(i):
            if dp[i] < dp[j] and line[i][1] > line[j][1]:
                dp[i] = dp[j]
        dp[i] += 1
    print(n - max(dp))

sol()