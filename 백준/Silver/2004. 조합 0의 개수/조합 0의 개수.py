import sys
input = lambda: sys.stdin.readline().strip()

def count(n, k):
    cnt = 0
    while (n):
        n = n // k
        cnt += n
    return cnt

def sol():
    n, m = map(int, input().split())
    print(min(count(n, 2) - count(m, 2) - count(n-m, 2),
              count(n, 5) - count(m, 5) - count(n-m, 5)))

sol()
