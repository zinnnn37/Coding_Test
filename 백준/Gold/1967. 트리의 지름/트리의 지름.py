import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def dfs(v, w):
	for a, b in graph[v]:
		if dist[a] == -1:
			dist[a] = w + b
			dfs(a, w + b)

if __name__ == '__main__':
	n = int(input())
	graph = [[] for _ in range(n+1)]
	for _ in range(n-1): # 트리의 간선 수는 n-1개(사이클이 없으므로)
		u, v, w = map(int, input().split())
		graph[u].append((v, w))
		graph[v].append((u, w))
	dist = [-1] * (n+1)
	dist[1] = 0
	dfs(1, 0) # 루트 노드에서 가장 먼 노드를 찾고
	start = dist.index(max(dist))
	dist = [-1] * (n+1)
	dist[start] = 0
	dfs(start, 0) # 루트에서 가장 먼 노드와 가장 먼 노드를 찾기
	print(max(dist))