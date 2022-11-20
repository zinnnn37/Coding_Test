import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def dijkstra(start, end):
	if start == end:
		return 0
	dp[start] = 0
	h = []
	heapq.heappush(h, (0, start))
	while h:
		w, cur = heapq.heappop(h)
		if dp[cur] < w:
			continue
		for v in tree[cur]:
			if dp[v] == -1:
				dp[v] = dp[cur] + 1
				heapq.heappush(h, (dp[v], v))
	return dp[end]

if __name__ == '__main__':
	ppl = int(input())
	n, m = map(int, input().split())
	tree = [[] for _ in range(ppl+1)]
	dp = [-1] * (ppl+1)
	dp[0] = 0
	for _ in range(int(input())):
		x, y = map(int, input().split())
		tree[x].append(y)
		tree[y].append(x)
	dijkstra(n, m)
	print(dp[m])