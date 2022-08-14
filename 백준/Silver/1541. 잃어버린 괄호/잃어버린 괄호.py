import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    str = input().split('-')
    add = []
    for i in str:
        res = 0
        s = i.split('+')
        for j in s:
            res += int(j)
        add.append(res)
    res = add[0]
    for i in range(1, len(add)):
        res -= add[i]
    print(res)

sol()