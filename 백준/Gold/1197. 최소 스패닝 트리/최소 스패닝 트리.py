import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def prim():
	ans = 0
	cnt = 0
	while h:
		if cnt == v:
			break
		w, c = heapq.heappop(h)
		if not visited[c]:
			visited[c] = 1
			ans += w
			cnt += 1
			for i in graph[c]:
				heapq.heappush(h, i)
	print(ans)

if __name__ == '__main__':
	v, e = map(int, input().split())
	visited = [0] * (v+1)
	graph = [[] for _ in range(v+1)]
	h = [(0, 1)]
	for _ in range(e):
		a, b, c = map(int, input().split())
		graph[a].append((c, b))
		graph[b].append((c, a))
	prim()