import sys
input = lambda: sys.stdin.readline().strip()

def mod(a, b, c):
    if b == 1:
        return a % c
    else:
        tmp = mod(a, b//2, c)
        if b % 2 == 0:
            return tmp * tmp % c
        else:
            return tmp * tmp * a % c

def sol():
    a, b, c = map(int, input().split())
    print(mod(a, b, c))

sol()