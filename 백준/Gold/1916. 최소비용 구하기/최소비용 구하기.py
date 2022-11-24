import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

def find_route(start, end):
	if start == end:
		return
	h = []
	heapq.heappush(h, (0, start))
	while h:
		w, cur = heapq.heappop(h)
		if dp[cur] < w:
			continue
		for weight, node in route[cur]:
			nxt_w = w + weight
			if dp[node] > nxt_w:
				dp[node] = nxt_w
				heapq.heappush(h, (nxt_w, node))

if __name__ == '__main__':
	INF = sys.maxsize
	city = int(input())
	bus = int(input())
	route = [[] for _ in range(city+1)]
	for _ in range(bus):
		a, b, c = map(int, input().split())
		heapq.heappush(route[a],(c, b))
	start, end = map(int, input().split())
	dp = [0 if i == start else INF for i in range(city + 1)]
	find_route(start, end)
	print(dp[end])