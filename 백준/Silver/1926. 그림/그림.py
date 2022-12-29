from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j):
	area = 1
	q = deque()
	q.append((i, j))
	paper[i][j] = 0
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w and paper[nx][ny] == 1:
				paper[nx][ny] = 0
				q.append((nx, ny))
				area += 1
	return area

if __name__ == '__main__':
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	h, w = map(int, input().split())
	paper = [list(map(int, input().split())) for _ in range(h)]
	cnt = 0
	area = 0
	for i in range(h):
		for j in range(w):
			if paper[i][j] == 1:
				cnt += 1
				area = max(area, bfs(i, j))
	print(cnt)
	print(area)