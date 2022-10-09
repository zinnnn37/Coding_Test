import sys
input = lambda: sys.stdin.readline().rstrip()

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n = int(input())

def bfs(x, y):
    global n
    family = 1
    q = [(x, y)]
    house[x][y] = '0'

    while q:
        x, y = q.pop(0)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if house[nx][ny] == '1':
                family += 1
                house[nx][ny] = '0'
                q.append((nx, ny))
    return family

house = [list(input()) for _ in range(n)]
cnt = 0
ans = []
for i in range(n):
    for j in range(n):
        if house[i][j] == '1':
            ans.append(bfs(i, j))
            cnt += 1
print(cnt)
for a in sorted(ans):
    print(a)