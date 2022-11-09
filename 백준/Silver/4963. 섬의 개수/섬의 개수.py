from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(x, y):
    q = deque()
    q.append((x, y))
    field[x][y] = 0
    while (q):
        a, b = q.popleft()
        for i in range(8):
            nx = a + dx[i]
            ny = b + dy[i]
            if 0 <= nx < m and 0 <= ny < n and field[nx][ny] == 1:
                field[nx][ny] = 0
                q.append((nx, ny))

if __name__ == '__main__':
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    while True:
        n, m = map(int, input().split())
        cnt = 0
        if n == 0 and m == 0:
            break
        field = [list(map(int, input().split())) for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if field[i][j] == 1:
                    bfs(i, j)
                    cnt += 1
        print(cnt)