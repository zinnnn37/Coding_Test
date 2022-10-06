from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]
dvisited = [0] * (n+1)
bvisited = [0] * (n+1)

def bfs(v):
    q = deque([v])
    bvisited[v] = 1
    print(v, end=' ')
    while q:
        t = q.popleft()
        graph[t].sort()
        for g in graph[t]:
            if bvisited[g] == 0:
                bvisited[g] = 1
                print(g, end=' ')
                q.append(g)

def dfs(v):
    dvisited[v] = 1
    print(v, end=' ')
    graph[v].sort()
    for g in graph[v]:
        if dvisited[g] == 0:
            dfs(g)

def sol():
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    dfs(v)
    print()
    bfs(v)

sol()