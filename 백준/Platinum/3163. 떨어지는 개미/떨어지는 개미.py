from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def drop_ant():
	ant = deque()
	sorted_lst = []
	ans = []
	
	for _ in range(n):
		loc, i = map(int, input().split())
		ant.append(i)
		sorted_lst.append([loc, i] if i < 0 else [L-loc, i])
	sorted_lst.sort()

	i = 0
	while ant:
		if i != n-1 and sorted_lst[i][0] == sorted_lst[i+1][0]:
			if ant[0] < ant[-1]:
				ans.append(ant.popleft())
				ans.append(ant.pop())
			else:
				ans.append(ant.pop())
				ans.append(ant.popleft())
			i += 2
		else:
			if sorted_lst[i][1] < 0:
				ans.append(ant.popleft())
			else:
				ans.append(ant.pop())
			i += 1
	print(ans[k-1])

if __name__ == '__main__':
	for _ in range(int(input())):
		n, L, k = map(int, input().split())
		drop_ant()