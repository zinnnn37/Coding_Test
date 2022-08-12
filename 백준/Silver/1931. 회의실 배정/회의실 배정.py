import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    conf = [list(map(int, input().split())) for _ in range(n)]
    conf.sort(key=lambda x: (x[1], x[0]))
    cnt = 0
    end = -1
    for lst in conf:
        if lst[0] >= end:
            end = lst[1]
            cnt += 1
    print(cnt)

sol()
