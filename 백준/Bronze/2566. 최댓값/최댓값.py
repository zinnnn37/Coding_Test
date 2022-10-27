import sys
input = lambda: sys.stdin.readline().rstrip()

x = 0
y = 0

matrix = [list(map(int, input().split())) for _ in range(9)]
for i in range(9):
    for j in range(9):
        if matrix[x][y] < matrix[i][j]:
            x, y = i, j
print(matrix[x][y])
print(x+1, y+1)