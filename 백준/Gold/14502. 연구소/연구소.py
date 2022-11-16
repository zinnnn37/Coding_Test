from collections import deque
import copy
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
	global res
	q = deque()
	tmp = copy.deepcopy(lab)
	for i in range(h):
		for j in range(w):
			if tmp[i][j] == 2:
				q.append((i, j))
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w and tmp[nx][ny] == 0:
				tmp[nx][ny] = 2
				q.append((nx, ny))
	cnt = 0
	for i in range(h):
		cnt += tmp[i].count(0)
	res = max(res, cnt)

def wall(cnt):
	if cnt == 3:
		bfs()
		return
	for i in range(h):
		for j in range(w):
			if lab[i][j] == 0:
				lab[i][j] = 1
				wall(cnt+1)
				lab[i][j] = 0

if __name__ == '__main__':
	h, w = map(int, input().split())
	lab = [list(map(int, input().split())) for _ in range(h)]
	dx = [1, 0, -1, 0]
	dy = [0, 1, 0, -1]
	res = 0
	wall(0)
	print(res)