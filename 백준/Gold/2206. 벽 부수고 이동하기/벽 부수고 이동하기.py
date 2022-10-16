from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
matrix = [list(input()) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
visited  = [[[0] * 2 for _ in range(m)] for _ in range(n)]

def bfs():
    q = deque([[0, 0, 0]])
    visited[0][0][0] = 1

    while q:
        x, y, wall = q.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][wall]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny][wall] == 0:
                if matrix[nx][ny] == '0':
                    q.append([nx, ny, wall])
                    visited[nx][ny][wall] = visited[x][y][wall] + 1
                if matrix[nx][ny] == '1' and wall == 0:
                    q.append([nx, ny, 1])
                    visited[nx][ny][1] = visited[x][y][wall] + 1
    return -1

print(bfs())