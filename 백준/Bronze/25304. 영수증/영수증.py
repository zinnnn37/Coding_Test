import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    total = int(input())
    user = 0
    for _ in range(int(input())):
        a, b = map(int, input().split())
        user += a * b
    if total == user:
        print('Yes')
    else:
        print('No')

sol()