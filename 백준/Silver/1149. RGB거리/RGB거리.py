import sys
input = lambda: sys.stdin.readline().strip()

def dp(n, matrix, ans):
    ans[0][0] = matrix[0][0]
    ans[0][1] = matrix[0][1]
    ans[0][2] = matrix[0][2]
    for i in range(1, n):
        for j in range(3):
            ans[i][j] = min(ans[i-1][j-1], ans[i-1][j-2]) + matrix[i][j]
    print(min(ans[n-1]))
    
def sol():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    ans = [[0 for i in range(3)] for j in range(n)]
    dp(n, matrix, ans)

sol()