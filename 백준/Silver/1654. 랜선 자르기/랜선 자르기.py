import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    k, n = map(int, input().split())
    lan = [int(input()) for _ in range(k)]
    start, end = 1, max(lan)
    while end >= start:
        mid = (start+end) // 2
        cnt = 0
        for length in lan:
            cnt += length // mid
        if cnt >= n:
            start = mid + 1
        else:
            end = mid - 1
    print(end)

sol()