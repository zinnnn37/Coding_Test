import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    res = 0
    for _ in range(n):
        maximum = max(a)
        minimum = min(b)
        res += maximum * minimum
        a.remove(maximum)
        b.remove(minimum)
    print(res)

sol()