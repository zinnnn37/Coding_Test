import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    m = [list(map(int, input().split())) for _ in range(n)]
    dp = [[0] * n for _ in range(n)]
    for gap in range(1, n):
        for start in range(n-gap):
            end = start + gap
            dp[start][end] = 2**32
            for k in range(start, end):
                dp[start][end] = min(dp[start][end], dp[start][k] + dp[k+1][end] + m[start][0] * m[k][1] * m[end][1])
    print(dp[0][-1])

sol()