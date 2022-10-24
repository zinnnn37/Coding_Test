import collections
import sys
input = lambda: sys.stdin.readline().rstrip()
INF = sys.maxsize

def bf(start):
    dp[start] = 0
    for i in range(n):
        for j in range(m):
            cur = graph[j][0]
            nxt = graph[j][1]
            weight = graph[j][2]
            if dp[cur] != INF and dp[nxt] > dp[cur] + weight:
                dp[nxt] = dp[cur] + weight
                if i == n-1:
                    return True
    return False

if __name__ == '__main__':
    n, m = map(int, input().split())
    graph = []
    dp = [INF] * (n+1)
    for _ in range(m):
        u, v, w = map(int, input().split())
        graph.append((u, v, w))
    
    if bf(1):
        print(-1)
    else:
        for i in range(2, n+1):
            if dp[i] == INF:
                print(-1)
            else:
                print(dp[i])