import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n = list(map(int, input().split()))
    n = [i * i for i in n]
    print(sum(n) % 10)

sol()