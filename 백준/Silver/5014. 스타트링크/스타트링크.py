from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(start, end):
	if start == end:
		return 0
	q = deque()
	q.append(start)
	while q:
		cur = q.popleft()
		for i in dx:
			nxt = cur + i
			if i == 0:
				continue
			if 1 <= nxt <= f and dp[nxt] == 0:
				dp[nxt] = dp[cur] + 1
				q.append(nxt)
	return dp[end] if dp[end] != 0 else 'use the stairs'

if __name__ == '__main__':
	f, s, g, u, d = map(int, input().split())
	dp = [0] * (f+1)
	dx = [u, -d]
	print(bfs(s, g))