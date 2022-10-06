from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
cnt = 0

def bfs():
    global cnt
    q = deque([1])
    visited[1] = 1
    while q:
        t = q.popleft()
        for g in graph[t]:
            if visited[g] == 0:
                cnt += 1
                visited[g] = 1
                q.append(g)

def sol():
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    bfs()
    print(cnt)

sol()