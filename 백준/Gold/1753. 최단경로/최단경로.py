import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(start):
    dp[start] = 0
    h = []
    heapq.heappush(h, (0, start))

    while h:
        weight, cur = heapq.heappop(h)
        if dp[cur] < weight:
            continue
        for w, v in graph[cur]:
            next_w = weight + w
            if next_w < dp[v]:
                dp[v] = next_w
                heapq.heappush(h, (next_w, v))

if __name__ == '__main__':
    INF = sys.maxsize
    V, E = map(int, input().split())
    k = int(input())
    graph = [[] for _ in range(V+1)]
    dp = [INF] * (V+1)
    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append([w, v])
    dijkstra(k)
    for i in range(1, V+1):
        print(dp[i] if dp[i] != INF else 'INF')