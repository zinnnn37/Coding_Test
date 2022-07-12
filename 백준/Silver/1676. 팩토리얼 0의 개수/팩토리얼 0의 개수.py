import sys
input = lambda: sys.stdin.readline().strip()

def fact(n):
    return n * fact(n-1) if n > 1 else 1

def sol():
    n = fact(int(input()))
    cnt = 0
    while n % 10 == 0:
        cnt += 1;
        n = n // 10
    print(cnt)

sol()