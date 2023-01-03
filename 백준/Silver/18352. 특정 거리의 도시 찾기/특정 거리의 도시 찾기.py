from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(start):
	visited[start] = 0
	q = deque()
	q.append(start)
	while q:
		x = q.popleft()
		for v in graph[x]:
			if 0 < v <= n and visited[v] == -1:
				visited[v] = visited[x] + 1
				q.append(v)

if __name__ == "__main__":
	n, m, k, x = map(int, input().split())
	graph = [[] for _ in range(n+1)]
	visited = [-1 for _ in range(n+1)]
	for _ in range(m):
		a, b = map(int, input().split())
		graph[a].append(b)
	bfs(x)
	flag = False
	for i in range(n+1):
		if visited[i] == k:
			print(i, end=' ')
			flag = True
	if not flag:
		print(-1)