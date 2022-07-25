import sys
input = lambda: sys.stdin.readline().strip()

def triangle(n, dp):
    dp[1] = dp[2] = dp[3] = 1
    for i in range(4, n+1):
        dp[i] = dp[i-3] + dp[i-2]
    return dp[n]

def sol():
    dp = [0] * 101
    for _ in range(int(input())):
        print(triangle(int(input()), dp))

sol()