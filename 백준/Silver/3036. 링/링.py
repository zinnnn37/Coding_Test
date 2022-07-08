import sys
input = lambda: sys.stdin.readline().strip()

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)

def fractal(numer, deno):
    g = gcd(numer, deno)
    print(f"{numer//g}/{deno//g}")

def sol():
    n = int(input())
    arr = list(map(int, input().split()))
    for i in range(1, n):
        fractal(arr[0], arr[i])

sol()