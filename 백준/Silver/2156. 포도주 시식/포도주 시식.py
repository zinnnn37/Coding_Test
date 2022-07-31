import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    wine = [0] * 10001
    for i in range(n):
        wine[i+1] = int(input())
    dp = [0] * 10001
    dp[1] = wine[1]
    dp[2] = wine[1] + wine[2]
    for i in range(3, n+1):
        dp[i] = max(dp[i-1], dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i])
    print(dp[n])

sol()