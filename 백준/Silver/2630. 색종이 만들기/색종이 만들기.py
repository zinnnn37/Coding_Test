import sys
input = lambda: sys.stdin.readline().strip()

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
white = 0
blue = 0

def paper(x, y, n):
    global white, blue
    color = matrix[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if color != matrix[i][j]:
                paper(x, y, n//2)
                paper(x, y+n//2, n//2)
                paper(x+n//2, y, n//2)
                paper(x+n//2, y+n//2, n//2)
                return
    if color == 0:
        white += 1
    else:
        blue += 1

paper(0, 0, n)
print(white)
print(blue)