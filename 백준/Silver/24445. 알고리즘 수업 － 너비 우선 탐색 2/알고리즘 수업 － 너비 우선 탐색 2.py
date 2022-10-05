from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

def bfs(r):
    cnt = 1
    q = deque([r])
    visited[r] = 1
    while q:
        t = q.popleft()
        graph[t].sort(reverse=True)
        for g in graph[t]:
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