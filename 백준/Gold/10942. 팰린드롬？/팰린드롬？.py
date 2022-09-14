import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    dp = [[0] * n for _ in range(n)]
    
    for gap in range(n):
        for start in range(n - gap):
            end = start + gap
            
            if start == end:
                dp[start][end] = 1
            elif nums[start] == nums[end]:
                if start + 1 == end:
                    dp[start][end] = 1
                elif dp[start+1][end-1] == 1:
                    dp[start][end] = 1
                    
    for _ in range(int(input())):
        s, e = map(int, input().split())
        print(dp[s-1][e-1])

sol()