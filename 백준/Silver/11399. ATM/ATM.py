import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    p = sorted(list(map(int, input().split())))
    if n > 1:
        for i in range(1, n):
            p[i] += p[i-1]
    print(sum(p))

sol()