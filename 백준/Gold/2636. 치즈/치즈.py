from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
	visited = [[False] * w for _ in range(h)]
	q = deque()
	q.append((0, 0))
	visited[0][0] = True
	cnt = 0
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny]:
				if cheese[nx][ny] == 0:
					visited[nx][ny] = True
					q.append((nx, ny))
				elif cheese[nx][ny] == 1:
					cheese[nx][ny] = 0
					cnt += 1
					visited[nx][ny] = True
	return cnt

if __name__ == '__main__':
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	h, w = map(int, input().split())
	cheese = [list(map(int, input().split())) for _ in range(h)]
	res = []
	time = -1
	while True:
		time += 1
		res.append(bfs())
		if res[-1] == 0:
			break
	print(time)
	print(res[-2])