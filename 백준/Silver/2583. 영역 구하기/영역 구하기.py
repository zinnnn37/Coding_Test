from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(x, y):
	q = deque()
	q.append((x, y))
	cnt = 1
	visited[x][y] = 2
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w and visited[nx][ny] == 0:
				visited[nx][ny] = 2
				cnt += 1
				q.append((nx, ny))
	return cnt

if __name__ == '__main__':
	dx = [1, 0, -1, 0]
	dy = [0, 1, 0, -1]
	h, w, k = map(int, input().split())
	visited = [[0 for _ in range(w)] for __ in range(h)]
	for _ in range(k):
		x1, y1, x2, y2 = map(int, input().split())
		for i in range(y1, y2):
			for j in range(x1, x2):
				visited[i][j] = 1
	cnt = 0
	res = []
	for i in range(h):
		for j in range(w):
			if visited[i][j] == 0:
				cnt += 1
				res.append(bfs(i, j))
	res.sort()
	print(cnt)
	print(*res)