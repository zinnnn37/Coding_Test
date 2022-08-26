import sys
input = lambda: sys.stdin.readline().strip()

minus = 0
zero = 0
one = 0

def cnt(x, y, n, paper):
    global minus, zero, one
    num = paper[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if paper[i][j] != num:
                cnt(x, y, n//3, paper)
                cnt(x, y+n//3, n//3, paper)
                cnt(x, y+2*(n//3), n//3, paper)
                cnt(x+n//3, y, n//3, paper)
                cnt(x+n//3, y+n//3, n//3, paper)
                cnt(x+n//3, y+2*(n//3), n//3, paper)
                cnt(x+2*(n//3), y, n//3, paper)
                cnt(x+2*(n//3), y+n//3, n//3, paper)
                cnt(x+2*(n//3), y+2*(n//3), n//3, paper)
                return
    if num == -1:
        minus += 1
    elif num == 0:
        zero += 1
    else:
        one += 1

def sol():
    n = int(input())
    paper = [list(map(int, input().split())) for _ in range(n)]
    cnt(0, 0, n, paper)
    print(minus)
    print(zero)
    print(one)

sol()