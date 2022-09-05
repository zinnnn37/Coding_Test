import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    k = int(input())
    start, end = 0, k
    res = 0
    while start <= end:
        mid = (start+end) // 2
        cnt = 0
        for i in range(1, n+1):
            cnt += min(mid//i, n)
        if cnt < k:
            start = mid + 1
        else:
            res = mid
            end = mid - 1
    print(res)

sol()