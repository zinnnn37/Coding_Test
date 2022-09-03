import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, m = map(int, input().split())
    length = list(map(int, input().split()))
    start, end = 1, max(length)
    while start <= end:
        mid = (start+end) // 2
        res = 0
        for l in length:
            tmp = l - mid
            if tmp > 0:
                res += tmp
        if res >= m:
            start = mid + 1
        else:
            end = mid - 1
    print(end)

sol()