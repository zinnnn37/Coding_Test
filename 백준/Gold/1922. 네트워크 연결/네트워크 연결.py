import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

def mst():
	cnt = 0
	ans = 0
	h = [(0, 1)]
	while h:
		if cnt == n:
			break
		w, v = heapq.heappop(h)
		if not visited[v]:
			visited[v] = True
			ans += w
			cnt += 1
			for i in network[v]:
				heapq.heappush(h, i)
	print(ans)

if __name__ == '__main__':
	n = int(input())
	m = int(input())
	network = [[] for _ in range(n+1)]
	visited = [False] * (n+1)
	for _ in range(m):
		a, b, c = map(int, input().split())
		network[a].append((c, b))
		network[b].append((c, a))
	mst()