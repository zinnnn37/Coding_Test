from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j):
	q = deque()
	q.append((i, j))
	visited[i][j] = 0
	res = 0
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w and visited[nx][ny] == -1 and island[nx][ny] == 'L':
				visited[nx][ny] = visited[x][y] + 1
				q.append((nx, ny))
				res = max(res, visited[nx][ny])
	return res

if __name__ == '__main__':
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	h, w = map(int, input().split())
	island = [list(input()) for _ in range(h)]
	res = 0
	for i in range(h):
		for j in range(w):
			if island[i][j] == 'L':
				visited = [[-1] * w for _ in range(h)]
				res = max(res, bfs(i, j))
	print(res)