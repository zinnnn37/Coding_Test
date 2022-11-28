from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j):
	global check
	check += 1
	visited[i][j] = True
	q = deque()
	q.append((i, j))
	unit = [(i, j)]
	cnt = 1
	ppl = country[i][j]
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
				if l <= abs(country[x][y] - country[nx][ny]) <= r:
					visited[nx][ny] = True
					q.append((nx, ny))
					unit.append((nx, ny))
					cnt += 1
					ppl += country[nx][ny]
	for i, j in unit:
		country[i][j] = ppl // cnt
	return check

if __name__ == '__main__':
	dx = [0, 1, 0, -1]
	dy = [1, 0, -1, 0]
	n, l, r = map(int, input().split())
	country = [list(map(int, input().split())) for _ in range(n)]
	ans = 0
	while True:
		visited = [[False] * n for _ in range(n)]
		check = 0
		ans += 1
		for i in range(n):
			for j in range(n):
				if not visited[i][j]:
					bfs(i, j)
		if check == n * n:
			print(ans-1)
			break