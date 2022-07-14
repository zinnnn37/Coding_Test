import sys
input = lambda: sys.stdin.readline().strip()

def dfs(n, m, arr):
    if len(arr) == m:
        print(*arr)
        return
    for i in range(1, n+1):
        if i not in arr:
            arr.append(i)
            dfs(n, m, arr)
            arr.pop()

def sol():
    n, m = map(int, input().split())
    arr = []
    dfs(n, m, arr)

sol()