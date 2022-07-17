import sys

board = []
zero = []

for i in range(9):
    board.append(list(map(int, sys.stdin.readline().split())))
    for j in range(9):
        if board[i][j] == 0:
            zero.append((i, j))

def check_lines(x, y, n):
    for i in range(9):
        if i != y and board[x][i] == n:
            return False
        if x != i and board[i][y] == n:
            return False
    return True

def check_box(x, y, n):
    a = 3 * (x // 3)
    b = 3 * (y // 3)
    for i in range(a, a + 3):
        for j in range(b, b + 3):
            if (i, j) != (x, y) and board[i][j] == n:
                return False
    return True

def dfs(i):
    if i == len(zero):
        return True
    
    x, y = zero[i]
    flag = False
    for n in range(1, 10):
        if check_lines(x, y, n) and check_box(x, y, n):
            flag = True
            board[x][y] = n
            if dfs(i + 1) == 0:
                board[x][y] = 0
                flag = False

    return True if flag else False

dfs(0)

for i in range(9):
    print(*board[i])