import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, k = map(int, input().split())
    x = list(map(int, input().split()))
    x.sort(reverse=True)
    print(x[k-1])

sol()