import sys
input = sys.stdin.readline

def sol():
    x = []
    y = []
    for _ in range(3):
        m, n = map(int, input().split())
        x.append(m)
        y.append(n)
    for i in x:
        if x.count(i) == 1:
            print(i, end=' ')
    for i in y:
        if y.count(i) == 1:
            print(i)

sol()