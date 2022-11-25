from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(start):
	visited = [0] * (n+1)
	q = deque()
	q.append(start)
	while q:
		x = q.popleft()
		for v in graph[x]:
			if visited[v] == 0:
				visited[v] = visited[x] + 1
				q.append(v)
	return sum(visited)

if __name__ == '__main__':
	INF = sys.maxsize
	n, m = map(int, input().split())
	graph = [[] for _ in range(n+1)]
	for _ in range(m):
		a, b = map(int, input().split())
		graph[a].append(b)
		graph[b].append(a)
	res = []
	for i in range(1, n+1):
		res.append(bfs(i))
	print(res.index(min(res))+1)