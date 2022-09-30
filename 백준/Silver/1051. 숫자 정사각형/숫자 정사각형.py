import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n, m = map(int, input().split())
    matrix = [list(input()) for _ in range(n)]
    l = n if n < m else m
    res = 0
    for i in range(n):
        for j in range(m):
            for gap in range(l):
                if i+gap >= n or j+gap >= m:
                    break
                if matrix[i][j] == matrix[i+gap][j] == matrix[i][j+gap] == matrix[i+gap][j+gap] and res < gap+1:
                    res = gap+1
    print(res*res)

sol()