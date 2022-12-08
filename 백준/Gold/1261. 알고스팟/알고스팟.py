from heapq import heappop, heappush
import sys
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(ex, ey):
	if ex == 0 and ey == 0:
		return 0
	h = []
	heappush(h, (0, 0, 0))
	visited[0][0] = 0
	while h:
		w, x, y = heappop(h)
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < m and 0 <= ny < n and visited[nx][ny] == -1:
				if graph[nx][ny] == 0:
					visited[nx][ny] = w
				else:
					visited[nx][ny] = w + 1
				heappush(h, (visited[nx][ny], nx, ny))
			if nx == ex and ny == ey:
				return visited[nx][ny]
	return visited[ex][ey]


if __name__ == '__main__':
	dx = [1, 0, -1, 0]
	dy = [0, 1, 0, -1]
	n, m = map(int, input().split())
	graph = [list(map(int, list(input()))) for _ in range(m)]
	visited = [[-1] * n for _ in range(m)]
	print(dijkstra(m-1, n-1))