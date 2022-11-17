import sys
input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
	n = int(input())
	graph = [list(map(int, input().split())) for _ in range(n)]
	visited = [[0] * n for _ in range(n)]
	for k in range(n):
		for i in range(n):
			for j in range(n):
				if graph[i][k] + graph[k][j] == 2 or graph[i][j]:
					graph[i][j] = 1
	for lst in graph:
		print(*lst)