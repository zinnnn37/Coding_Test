import sys
input = lambda: sys.stdin.readline().strip()

def compress(x, y, n, lst):
    if n == 1:
        print(lst[x][y], end='')
        return
    color = lst[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != lst[i][j]:
                print('(', end='')
                compress(x, y, n//2, lst)
                compress(x, y+n//2, n//2, lst)
                compress(x+n//2, y, n//2, lst)
                compress(x+n//2, y+n//2, n//2, lst)
                print(')', end='')
                return
    print(color, end='')

def sol():
    n = int(input())
    lst = [list(map(int, list(input()))) for _ in range(n)]
    compress(0, 0, n, lst)

sol()