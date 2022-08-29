import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, m = map(int, input().split())
    a = [list(map(int, input().split())) for _ in range(n)]
    m, k = map(int, input().split())
    b = [list(map(int, input().split())) for _ in range(m)]
    res = [[0 for _ in range(k)] for _ in range(n)]
    for i in range(n):
        for j in range(k):
            for l in range(m):
                res[i][j] += a[i][l] * b[l][j]
    for lst in res:
        print(*lst)

sol()