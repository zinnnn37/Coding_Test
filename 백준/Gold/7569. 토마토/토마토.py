from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

m, n, h = map(int, input().split())
box = []
q = deque([])
for i in range(h):
    tmp = []
    for j in range(n):
        tmp.append(list(map(int, input().split())))
        for k in range(m):
            if tmp[j][k] == 1:
                q.append([i, j, k])
    box.append(tmp)

while q:
    x, y, z = q.popleft()

    for i in range(6):
        a = x + dx[i]
        b = y + dy[i]
        c = z + dz[i]
        if 0 <= a < h and 0 <= b < n and 0 <= c < m and box[a][b][c] == 0:
            q.append([a, b, c])
            box[a][b][c] = box[x][y][z] + 1

ans = 0
for i in box:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit(0)
            ans = max(ans, k)
print(ans - 1)