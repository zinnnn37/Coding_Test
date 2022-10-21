import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(start):
    INF = sys.maxsize
    h = []
    heapq.heappush(h, (start, 0))
    dp = [INF for _ in range(n+1)]
    dp[start] = 0
    while h:
        cur, weight = heapq.heappop(h)
        for nxt, w in graph[cur]:
            nxt_w = weight + w
            if dp[nxt] > nxt_w:
                dp[nxt] = nxt_w
                heapq.heappush(h, (nxt, nxt_w))
    return dp

if __name__ == '__main__':
    for _ in range(int(input())):
        n, m, t = map(int, input().split())
        s, g, h = map(int, input().split())
        graph = [[] for _ in range(n+1)]
        dest = [0] * t
        for _ in range(m):
            a, b, d = map(int, input().split())
            graph[a].append((b, d))
            graph[b].append((a, d))
        for i in range(t):
            dest[i] = int(input())
        start = dijkstra(s)
        res_g = dijkstra(g)
        res_h = dijkstra(h)
        res = []
        for de in dest:
            if start[g] + res_g[h] + res_h[de] == start[de] or start[h] + res_h[g] + res_g[de] == start[de]:
                res.append(de)
        res.sort()
        print(*res)