import sys
input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y):
	q = [(x, y)]
	lettuce[x][y] = 0

	while q:
		x, y = q.pop(0)
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx >= m or ny < 0 or ny >= n:
				continue
			if lettuce[nx][ny] == 1:
				q.append((nx, ny))
				lettuce[nx][ny] = 0


for _ in range(int(input())):
	m, n, k = map(int, input().split())
	lettuce = [[0] * n for _ in range(m)]
	cnt = 0
	for _ in range(k):
		x, y = map(int, input().split())
		lettuce[x][y] = 1
	for i in range(m):
		for j in range(n):
			if lettuce[i][j] == 1:
				bfs(i, j)
				cnt += 1
	print(cnt)