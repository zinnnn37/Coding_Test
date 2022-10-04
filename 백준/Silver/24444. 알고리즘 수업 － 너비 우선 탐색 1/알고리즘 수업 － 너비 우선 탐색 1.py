from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
cnt = 1

def bfs(r):
    global cnt
    q = deque([r])
    visited[r] = 1
    while q:
        v = q.popleft()
        graph[v].sort()
        for g in graph[v]:
            if visited[g] == 0:
                cnt += 1
                visited[g] = cnt
                q.append(g)

def sol():
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    bfs(r)
    print(*visited[1:])

sol()