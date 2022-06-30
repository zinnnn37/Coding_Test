import sys
input = sys.stdin.readline

def sol():
    x, y, w, h = map(int, input().split())
    print(min(x, y, w-x, h-y))

sol()