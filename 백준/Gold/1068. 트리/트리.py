import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(target, arr):
	arr[target] = -2 # 삭제할 노드의 값을 -2로 변경
	for i in range(n):
		if target == arr[i]: # 삭제할 노드를 부모 노드로 가지는 자식 노드도 -2로 변경(dfs에서)
			dfs(i, arr)

if __name__ == '__main__':
	n = int(input())
	arr = list(map(int, input().split()))
	target = int(input())
	cnt = 0
	dfs(target, arr)
	for i in range(n):
		if arr[i] != -2 and i not in arr: # 삭제한 노드가 아니며 배열에 없을 경우(부모노드가 아닌 경우)
			cnt += 1
	print(cnt)