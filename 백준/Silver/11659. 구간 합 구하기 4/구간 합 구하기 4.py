import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, m = map(int, input().split())
    nums = list(map(int, input().split()))
    sum = [0]
    tmp = 0
    for n in nums:
        tmp += n
        sum.append(tmp)
    for _ in range(m):
        i, j = map(int, input().split())
        print(sum[j] - sum[i-1])

sol()