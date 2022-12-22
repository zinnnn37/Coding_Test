from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
	q = deque()
	q.append(home)
	while q:
		x, y = q.popleft()
		if abs(x - festival[0]) + abs(y - festival[1]) <= 1000:
			print('happy')
			return
		for i in range(n):
			if not visited[i]:
				nx, ny = store[i]
				if abs(x - nx) + abs(y - ny) <= 1000:
					q.append([nx, ny])
					visited[i] = True
	print('sad')
	return

if __name__ == '__main__':
	for _ in range(int(input())):
		n = int(input())
		home = list(map(int, input().split()))
		store = []
		for __ in range(n):
			a, b = map(int, input().split())
			store.append([a, b])
		festival = list(map(int, input().split()))
		visited = [False for ___ in range(n+1)]
		bfs()