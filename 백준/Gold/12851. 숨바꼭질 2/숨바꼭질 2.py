from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(s):
	q = deque([s])
	dp[s][0] = 0;
	dp[s][1] = 1;
	while q:
		cur = q.popleft()
		for nxt in [cur + 1, cur - 1, cur * 2]:
			if 0 <= nxt <= 100000:
				if dp[nxt][0] == -1:
					dp[nxt][0] = dp[cur][0] + 1
					dp[nxt][1] = dp[cur][1]
					q.append(nxt)
				elif dp[nxt][0] == dp[cur][0] + 1:
					dp[nxt][1] += dp[cur][1]

if __name__ == '__main__':
	n, k = map(int, input().split())
	dp = [[-1, 0] for _ in range(100001)]
	bfs(n)
	print(dp[k][0])
	print(dp[k][1])