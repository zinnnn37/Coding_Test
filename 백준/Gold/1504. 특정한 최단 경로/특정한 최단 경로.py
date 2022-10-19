import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(start, end):
	if start == end:
		return 0
	dp = [INF] * (N+1)
	dp[0] = 0
	h = []
	heapq.heappush(h, (0, start))

	while h:
		weight, cur = heapq.heappop(h)
		if dp[cur] < weight:
			continue
		for v, w in graph[cur]:
			next_w = weight + w
			if next_w < dp[v]:
				dp[v] = next_w
				heapq.heappush(h, (next_w, v))
	return dp[end]

if __name__ == '__main__':
	N, E = map(int, input().split())
	INF = sys.maxsize
	graph = [[] for _ in range(N+1)]
	for _ in range(E):
		a, b, c = map(int, input().split())
		graph[a].append([b, c])
		graph[b].append([a, c])
	v1, v2 = map(int, input().split())
	ans = min(dijkstra(1, v1) + dijkstra(v2, N), dijkstra(1, v2) + dijkstra(v1, N)) + dijkstra(v1, v2)
	print(ans if ans < INF else -1)