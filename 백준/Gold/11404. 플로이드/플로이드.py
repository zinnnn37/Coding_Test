import sys
input = lambda: sys.stdin.readline().rstrip()

def floyd_warshall():
	for k in range(1, n+1):
		for i in range(1, n+1):
			for j in range(1, n+1):
				route[i][j] = min(route[i][j], route[i][k] + route[k][j])

if __name__ == '__main__':
	INF = sys.maxsize
	n = int(input())
	route = [[INF if i != j else 0 for j in range(n+1)] for i in range(n+1)]
	for _ in range(int(input())):
		a, b, c = map(int, input().split())
		if route[a][b] > c:
			route[a][b] = c
	floyd_warshall()
	for lst in route[1:]:
		for l in lst[1:]:
			print(l if l != INF else 0, end=' ')
		print()