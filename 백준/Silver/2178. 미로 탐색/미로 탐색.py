import sys
input = lambda: sys.stdin.readline().rstrip()

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
n, m = map(int, input().split())
maze = [list(input()) for _ in range(n)]
maze[0][0] = 1

def bfs(x, y):
    q = [(x, y)]

    while q:
        x, y = q.pop(0)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and maze[nx][ny] == "1":
                q.append((nx, ny))
                maze[nx][ny] = maze[x][y] + 1
    return maze[n-1][m-1]

print(bfs(0, 0))