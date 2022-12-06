from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(Dx, Dy):
	while q:
		if forest[Dx][Dy] == 'S':
			return dp[Dx][Dy]
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < r and 0 <= ny < c:
				if forest[x][y] == 'S' and (forest[nx][ny] == '.' or forest[nx][ny] == 'D'):
					forest[nx][ny] = 'S'
					dp[nx][ny] = dp[x][y] + 1
					q.append((nx, ny))
				elif forest[x][y] == '*' and (forest[nx][ny] == '.' or forest[nx][ny] == 'S'):
					forest[nx][ny] = '*'
					q.append((nx, ny))
	return "KAKTUS"

if __name__ == '__main__':
	r, c = map(int, input().split())
	forest = [list(input()) for _ in range(r)]
	dp = [[0] * c for _ in range(r)]
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	q = deque()
	for i in range(r):
		for j in range(c):
			if forest[i][j] == 'S':
				q.append((i, j))
			elif forest[i][j] == 'D':
				Dx, Dy = i, j
	for i in range(r):
		for j in range(c):
			if forest[i][j] == '*':
				q.append((i, j))
	print(bfs(Dx, Dy))