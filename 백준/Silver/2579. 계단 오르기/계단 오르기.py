import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    stairs = [0] * 301
    for i in range(n):
        stairs[i+1] = int(input())
    dp = [0] * 301
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    for i in range(3, n+1):
        dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i])
    print(dp[n])

sol()