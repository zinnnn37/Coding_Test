import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(v, cnt):
	global flag
	visited[v] = True
	if cnt == 4:
		flag = True
		return
	for i in relations[v]:
		if not visited[i]:
			visited[i] = True
			dfs(i, cnt + 1)
			visited[i] = False

if __name__ == '__main__':
	n, m = map(int, input().split())
	relations = [[] for _ in range(n)]
	visited = [False] * 2001
	flag = False
	for _ in range(m):
		a, b = map(int, input().split())
		relations[a].append(b)
		relations[b].append(a)
	for i in range(n):
		dfs(i, 0)
		visited[i] = False
		if flag:
			break
	print(1 if flag else 0)