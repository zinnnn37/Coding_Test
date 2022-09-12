import sys
sys.setrecursionlimit(10**5)
input = lambda: sys.stdin.readline().strip()

def dfs(x, y):
    if x == m-1 and y == n-1:
        return 1
    if visited[x][y] != -1:
        return visited[x][y]
    route = 0
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < m and 0 <= ny < n and matrix[x][y] > matrix[nx][ny]:
            route += dfs(nx, ny)
    visited[x][y] = route
    return visited[x][y]

m, n = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(m)]
visited = [[-1] * n for _ in range(m)]
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
print(dfs(0, 0))