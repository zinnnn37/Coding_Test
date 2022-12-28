from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def to_one(n):
	q = deque()
	q.append([n])
	ans = []

	while q:
		a = q.popleft()
		x = a[0]
		if x == 1:
			ans = a
			break
		if x % 3 == 0:
			q.append([x // 3] + a)
		if x % 2 == 0:
			q.append([x // 2] + a)
		q.append([x-1] + a)
	print(len(ans) - 1)
	print(*ans[::-1])

if __name__ == '__main__':
	n = int(input())
	to_one(n)