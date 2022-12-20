import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def postorder(start, end):
	if start > end:
		return
	mid = end + 1
	for i in range(start+1, end+1):
		if num[start] < num[i]:
			mid = i
			break
	postorder(start+1, mid-1)
	postorder(mid, end)
	print(num[start])

if __name__ == '__main__':
	num = []
	while True:
		try:
			num.append(int(input()))
		except:
			break
	postorder(0, len(num)-1)