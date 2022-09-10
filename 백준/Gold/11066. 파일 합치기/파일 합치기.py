import sys
input = lambda: sys.stdin.readline().strip()

INF = sys.maxsize
def sol():
    for _ in range(int(input())):
        n = int(input())
        file = list(map(int, input().split()))
        dp = [[0 for i in range(n)] for j in range(n)]
        s = [sum(file[0:i+1]) for i in range(n)]
        for gap in range(1, n):
            for start in range(n-gap):
                end = start + gap
                dp[start][end] = INF
                for k in range(start, end):
                    dp[start][end] = min(dp[start][end], dp[start][k] + dp[k+1][end])
                dp[start][end] += s[end] - s[start-1] if start != 0 else s[end]
        print(dp[0][-1])

sol()