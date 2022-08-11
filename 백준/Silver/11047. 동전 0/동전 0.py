import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, k = map(int, input().split())
    a = [int(input()) for _ in range(n)]
    a.sort(reverse=True)
    cnt = 0
    for p in a:
        if k < p:
            continue
        cnt += k // p
        k %= p
    print(cnt)

sol()