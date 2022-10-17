from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(graph, start):
	q = deque([start])
	if visited[start] == 0:
		visited[start] = 1
	while q:
		v = q.popleft()
		color = visited[v]
		for i in graph[v]:
			if visited[i] == 0:
				q.append(i)
				if color == 1:
					visited[i] = 2
				else:
					visited[i] = 1
			elif visited[i] == color:
				print('NO')
				return False
	return True

for _ in range(int(input())):
	flag = 0
	V, E = map(int, input().split())
	graph = [[] for _ in range(V+1)]
	visited = [0] * (V+1)
	for __ in range(E):
		u, v = map(int, input().split())
		graph[u].append(v)
		graph[v].append(u)
	for i in range(1, V+1):
		if not bfs(graph, i):
			flag = 1
			break
	if flag == 0:
		print('YES')