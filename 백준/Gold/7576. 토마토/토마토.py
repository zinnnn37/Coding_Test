from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
q = deque([])

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            q.append([i, j])

def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                q.append([nx, ny])

bfs()

ans = -10000
flag = True
for lst in box:
    for e in lst:
        if e == 0:
            flag = False
            break;
        if e > ans:
            ans = e
if flag:
    print(ans - 1)
else:
    print(-1)