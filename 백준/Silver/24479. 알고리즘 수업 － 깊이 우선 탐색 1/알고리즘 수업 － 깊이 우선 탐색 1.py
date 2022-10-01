import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**7)

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
cnt = 1

def dfs(r):
    global cnt
    visited[r] = cnt
    graph[r].sort()
    for g in graph[r]:
        if visited[g] == 0:
            cnt += 1
            dfs(g)

def sol():
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    dfs(r)
    print(*visited[1:])

sol()