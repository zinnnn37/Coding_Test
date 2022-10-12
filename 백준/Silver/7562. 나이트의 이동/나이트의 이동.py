import sys
input = lambda: sys.stdin.readline().rstrip()

dx = [1, 1, 2, 2, -1, -1, -2, -2]
dy = [2, -2, 1, -1, 2, -2, 1, -1]

def bfs(kx, ky, fx, fy, n):
    q = [[kx, ky]]
    visited = [[0] * n for _ in range(n)]

    while q:
        x, y = q.pop(0)
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx == x and ny == y:
                visited[nx][ny] = visited[x][y] + 1
                break
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
    return visited[fx][fy]

def sol():
    for _ in range(int(input())):
        n = int(input())
        kx, ky = map(int, input().split())
        fx, fy = map(int, input().split())
        if kx == fx and fx == fy:
            print(0)
        else:
            print(bfs(kx, ky, fx, fy, n))

sol()