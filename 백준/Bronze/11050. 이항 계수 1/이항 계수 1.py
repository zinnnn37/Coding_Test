import sys
input = lambda: sys.stdin.readline().strip()

def fact(n):
    return n * fact(n-1) if n > 1 else 1

def sol():
    n, k = map(int, input().split())
    print(fact(n) // (fact(k)*fact(n-k)))

sol()