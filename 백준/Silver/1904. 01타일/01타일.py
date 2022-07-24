import sys
input = lambda: sys.stdin.readline().strip()

def binary(n, dp):
    dp[1], dp[2] = 1, 2
    for i in range(3, n+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 15746
    return dp[n]

def sol():
    n = int(input())
    dp = [0] * (n + 2)
    print(binary(n, dp))

sol()