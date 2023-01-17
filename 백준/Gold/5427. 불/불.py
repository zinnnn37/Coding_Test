from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
	while q:
		x, y = q.popleft()		
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < h and 0 <= ny < w:
				if visited[nx][ny] == -1 and (building[nx][ny] == '.' or building[nx][ny] == '@'):
					if visited[x][y] == -2:
						visited[nx][ny] = visited[x][y]
					else:
						visited[nx][ny] = visited[x][y] + 1
					q.append((nx, ny))
			else:
				if visited[x][y] != -2:
				# 다음 이동이 building을 벗어난다 == 현재 벽쪽에 위치한다 && q에서 pop된 요소는 벽일 수 없음
					return visited[x][y] + 1
	return "IMPOSSIBLE"

if __name__ == '__main__':
	dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
	for _ in range(int(input())):
		q = deque()
		w, h = map(int, input().split())
		building = [list(input()) for _ in range(h)]
		visited = [[-1] * w for _ in range(h)]
		for i in range(h):
			for j in range(w):
				if building[i][j] == '@':
					visited[i][j] = 0
					start = (i, j)
				elif building[i][j] == '*':
					visited[i][j] = -2
					q.append((i, j))
		q.append(start)
		print(bfs())