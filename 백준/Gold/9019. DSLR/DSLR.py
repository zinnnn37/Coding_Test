from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def dslr(start, end):
	q = deque()
	q.append((start, ""))
	visited = [False] * 10000
	visited[start] = True
	while q:
		cur, path = q.popleft()
		if cur == end:
			print(path)
			return
		tmp = (cur * 2) % 10000
		if not visited[tmp]:
			q.append((tmp, path + 'D'))
			visited[tmp] = True
		tmp = (cur - 1) % 10000
		if not visited[tmp]:
			q.append((tmp, path+'S'))
			visited[tmp] = True
		tmp = (cur * 10 + (cur // 1000)) % 10000
		if not visited[tmp]:
			q.append((tmp, path+"L"))
			visited[tmp] = True
		tmp = (cur * 1000 + (cur // 10)) % 10000
		if not visited[tmp]:
			q.append((tmp, path+"R"))
			visited[tmp] = True

if __name__ == '__main__':
	d, s, l, r = 'd', 's', 'l', 'r'
	for _ in range(int(input())):
		a, b = map(int, input().split())
		dslr(a, b)