from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(start):
	cnt = 1
	visited = [False] * (n+1)
	visited[start] = True
	q = deque()
	q.append(start)
	while q:
		cur = q.popleft()
		for v in pc[cur]:
			if not visited[v]:
				q.append(v)
				visited[v] = True
				cnt += 1
	return cnt

if __name__ == '__main__':
	n, m = map(int, input().split())
	pc = [[] for _ in range(n+1)]
	for _ in range(m):
		a, b = map(int, input().split())
		pc[b].append(a)
	maxi = 0
	res = [0]
	for i in range(1, n+1):
		res.append(bfs(i))
		maxi = max(res[-1], maxi);
	for i in range(1, n+1):
		if res[i] == maxi:
			print(i, end=' ');