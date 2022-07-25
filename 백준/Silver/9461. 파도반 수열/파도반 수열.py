import sys
input = lambda: sys.stdin.readline().strip()

def triangle(n, dp):
    dp[1] = dp[2] = dp[3] = 1
    for i in range(4, n+1):
        dp[i] = dp[i-3] + dp[i-2]
    return dp[n]

def sol():
    for _ in range(int(input())):
        n = int(input())
        dp = [0] * (n + 3)
        print(triangle(n, dp))

sol()