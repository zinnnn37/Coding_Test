import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(target, arr):
	arr[target] = -2
	for i in range(n):
		if target == arr[i]:
			dfs(i, arr)

if __name__ == '__main__':
	n = int(input())
	arr = list(map(int, input().split()))
	target = int(input())
	cnt = 0
	dfs(target, arr)
	for i in range(n):
		if arr[i] != -2 and i not in arr:
			cnt += 1
	print(cnt)