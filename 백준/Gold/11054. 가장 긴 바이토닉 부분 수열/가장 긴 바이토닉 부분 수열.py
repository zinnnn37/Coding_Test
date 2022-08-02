import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    front = [0 for _ in range(n)]
    rear = [0 for _ in range(n)]
    for i in range(n):
        for j in range(i):
            if nums[i] > nums[j] and front[i] < front[j]:
                front[i] = front[j]
            if nums[n-i-1] > nums[n-j-1] and rear[n-i-1] < rear[n-j-1]:
                rear[n-i-1] = rear[n-j-1]
        front[i] += 1
        rear[n-i-1] += 1
    res = 0
    for i in range(n):
        if front[i] + rear[i] > res:
            res = front[i] + rear[i] - 1
    print(res)

sol()