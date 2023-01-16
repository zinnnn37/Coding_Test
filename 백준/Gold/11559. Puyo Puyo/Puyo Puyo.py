from copy import deepcopy
from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(i, j, c):
	q = deque()
	q.append((i, j))
	remove = deque()
	remove.append((i, j))

	visited = [[False] * 6 for _ in range(12)]
	visited[i][j] = True
	cnt = 1
	flag = 0
	while q:
		x, y = q.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < 12 and 0 <= ny < 6 and puyo[nx][ny] == c and not visited[nx][ny]:
				q.append((nx, ny))
				remove.append((nx, ny))
				visited[nx][ny] = True
				cnt += 1
	if cnt >= 4:
		flag = 1
		for x, y in remove:
			puyo[x][y] = '.'
	return flag

def move():
	for y in range(6):
		q = deque()
		for x in range(11, -1, -1):
			if puyo[x][y] != '.':
				q.append(puyo[x][y])
		for x in range(11, -1, -1):
			if q:
				puyo[x][y] = q.popleft()
			else:
				puyo[x][y] = '.'

if __name__ == '__main__':
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	puyo = [list(input()) for _ in range(12)]
	ans = 0
	while True:
		cnt = 0
		for i in range(12):
			for j in range(6):
				if puyo[i][j] != '.':
					cnt += bfs(i, j, puyo[i][j])
		if cnt == 0:
			print(ans)
			break
		else:
			ans += 1
		move()