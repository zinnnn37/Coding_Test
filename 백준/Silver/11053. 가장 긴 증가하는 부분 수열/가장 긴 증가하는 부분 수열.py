import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    dp = [0 for _ in range(n)]
    for i in range(n):
        for j in range(i):
            if nums[i] > nums[j] and dp[i] < dp[j]:
                dp[i] = dp[j]
        dp[i] += 1
    print(max(dp))

sol()