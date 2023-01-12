from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
	q = deque()
	q.append([a, 0])
	visited = [False] * 10000
	visited[a] = True
	while q:
		cur, cnt = q.popleft()
		if cur == b:
			return cnt
		cur_s = str(cur)
		for i in range(4):
			for j in range(10):
				nxt = int(cur_s[:i] + str(j) + cur_s[i+1:])
				if not visited[nxt] and prime[nxt] and nxt >= 1000:
					visited[nxt] = True
					q.append([nxt, cnt + 1])

if __name__ == '__main__':
	prime = [True] * 10000
	for i in range(2, 100):
		if prime[i]:
			for j in range(i * 2, 10000, i):
				prime[j] = False

	for _ in range(int(input())):
		a, b = map(int, input().split())
		res = bfs()
		print(res if res != None else "Impossible")