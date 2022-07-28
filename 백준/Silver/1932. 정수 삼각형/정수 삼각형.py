import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    tri = [list(map(int, input().split())) for _ in range(n)]
    ans = [[0] * (i+1) for i in range(n)]
    ans[0][0] = tri[0][0]
    for i in range(1, n):
        for j in range(i+1):
            if j == 0 or j == i:
                if j == 0:
                    ans[i][j] = tri[i][j] + ans[i-1][j]
                if j == i:
                    ans[i][j] = tri[i][j] + ans[i-1][j-1]
            else:
                ans[i][j] = tri[i][j] + max(ans[i-1][j-1], ans[i-1][j])
    print(max(ans[n-1]))

sol()