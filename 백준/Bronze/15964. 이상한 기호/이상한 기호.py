import sys
input = lambda: sys.stdin.readline().rstrip()

def func(a, b):
    print((a+b)*(a-b))

def sol():
    a, b = map(int, input().split())
    func(a, b)

sol()