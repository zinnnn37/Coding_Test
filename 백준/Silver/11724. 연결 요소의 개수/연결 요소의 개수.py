import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def dfs(v):
    visited[v] = 1
    for u in graph[v]:
        if visited[u] == 0:
            dfs(u)

if __name__ == '__main__':
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    visited = [0] * (n+1)
    cnt = 0
    for v in range(1, n+1):
        if visited[v] == 0:
            dfs(v)
            cnt += 1
    print(cnt)