import sys
input = lambda: sys.stdin.readline().rstrip()

def sol(n, b, a):
	sum = 0
	for i in range(a):
	# 할인을 받을 수 있는 만큼 저렴한 선물부터 구매
		sum += (price[i] // 2)
		if sum > b:
			return i
	
	left = 0
	for right in range(a, n):
		sum += (price[left] // 2)
		sum += (price[right] // 2)
		if sum > b:
			return right
		left += 1
	return n

if __name__ == '__main__':
	n, b, a = map(int, input().split())
	price = sorted(list(map(int, input().split())))
	print(sol(n, b, a))