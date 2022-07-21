import sys
input = lambda: sys.stdin.readline().strip()

cnt_fib = 0

def fib(n):
    global cnt_fib
    cnt_fib += 1
    if n == 1 or n == 2:
        return 1
    return fib(n - 1) + fib(n - 2)

def fibonacci(n):
    f = [0] * (n + 1)
    f[1] = f[2] = 1
    cnt = 0
    for i in range(3, n + 1):
        f[1] = f[i - 1] + f[i - 2]
        cnt += 1
    return cnt;

def sol():
    n = int(input())
    fib(n)
    cnt = fibonacci(n)
    print(cnt_fib // 2 + 1, cnt)

sol()