import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def dfs(n):
	for i in graph[n]:
		if visited[i] == 0:
			visited[i] = n
			dfs(i)

if __name__ == '__main__':
	n = int(input())
	graph = [[] for _ in range(n+1)]
	visited = [0] * (n+1)
	for _ in range(n-1):
		u, v = map(int, input().split())
		graph[v].append(u)
		graph[u].append(v)
	dfs(1)
	for i in range(2, n+1):
		print(visited[i])