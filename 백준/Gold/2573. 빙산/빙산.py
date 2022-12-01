from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j):
	q = deque()
	q.append((i, j))
	visited[i][j] = True
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < n and 0 <= ny < m:
				if glacier[nx][ny] != 0 and not visited[nx][ny]:
					visited[nx][ny] = True
					q.append((nx, ny))
				elif glacier[nx][ny] == 0:
					cnt[x][y] += 1
	return 1

if __name__ == '__main__':
	dx = [1, 0, -1, 0]
	dy = [0, 1, 0, -1]
	day = 0
	n, m = map(int, input().split())
	glacier = [list(map(int, input().split())) for _ in range(n)]
	while True:
		res = 0
		visited = [[False] * m for _ in range(n)]
		cnt = [[0] * m for _ in range(n)]
		for i in range(n):
			for j in range(m):
				if glacier[i][j] != 0 and not visited[i][j]:
					res += bfs(i, j)
		for i in range(n):
			for j in range(m):
				glacier[i][j] = glacier[i][j] - cnt[i][j] if glacier[i][j] - cnt[i][j] > 0 else 0
		if res == 0:
			print(0)
			break
		if res >= 2:
			print(day)
			break
		day += 1