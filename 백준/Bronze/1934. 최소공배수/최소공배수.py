import sys
input = lambda: sys.stdin.readline().strip()

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a%b)

def sol():
    for _ in range(int(input())):
        a, b = map(int, input().split())
        print(int(a * b / gcd(a, b)))

sol()