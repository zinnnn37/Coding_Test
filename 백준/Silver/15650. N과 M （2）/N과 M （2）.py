import sys
input = lambda: sys.stdin.readline().strip()

def dfs(i, cur, n, m, arr):
    if i == m:
        print(*arr)
        return
    while (cur <= n):
        arr[i] = cur
        dfs(i + 1, cur + 1, n, m, arr)
        cur += 1

def sol():
    n, m = map(int, input().split())
    arr = [0] * m
    dfs(0, 1, n, m, arr)

sol()