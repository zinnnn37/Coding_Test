import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    sum = [nums[0]]
    for i in range(1, n):
        sum.append(max(sum[i-1] + nums[i], nums[i]))
    print(max(sum))

sol()