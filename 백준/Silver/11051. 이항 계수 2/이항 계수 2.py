import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, k = map(int, input().split())
    pas = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for i in range(0, n+1):
        pas[i][0] = 1
        for j in range(1, i + 1):
            pas[i][j] = pas[i-1][j-1] + pas[i-1][j]
    print(pas[n][k] % 10007)

sol()