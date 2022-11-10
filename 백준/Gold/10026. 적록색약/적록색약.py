from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j):
	dx = [0, 1, 0, -1]
	dy = [1, 0, -1, 0]
	q = deque()
	q.append((i, j))
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < n and 0 <= ny < n and ((nx, ny) not in visited):
				if color[nx][ny] == color[x][y]:
					q.append((nx, ny))
					visited.append((nx, ny))

if __name__ == '__main__':
	n = int(input())
	color = [input() for _ in range(n)]
	visited = []
	res1 = 0
	res2 = 0
	for i in range(n):
		for j in range(n):
			if (i, j) not in visited:
				bfs(i, j)
				res1 += 1
	visited = []
	for i in range(n):
		color[i] = color[i].replace('R', 'G')
	for i in range(n):
		for j in range(n):
			if (i, j) not in visited:
				bfs(i, j)
				res2 += 1
	print(res1, res2)