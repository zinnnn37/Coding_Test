from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(a, b):
	q = deque()
	q.append((a, 1))
	while q:
		c, w = q.popleft()
		if c > b:
			continue
		if c == b:
			print(w)
			return
		q.append((int(str(c) + '1'), w+1))
		q.append((c*2, w+1))
	else:
		print(-1)

if __name__ == '__main__':
	a, b = map(int, input().split())
	bfs(a, b)