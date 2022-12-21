import sys
input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
	for _ in range(int(input())):
		n, m = map(int, input().split())
		for _ in range(m):
			input()
		print(n-1)