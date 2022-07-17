import sys
input = lambda: sys.stdin.readline().strip()

def check_lines(board, x, y, n):
    for i in range(9):
        if i != y and board[x][i] == n:
            return 0
        if x != i and board[i][y] == n:
            return 0
    return 1

def check_box(board, x, y, n):
    a = 3 * (x // 3)
    b = 3 * (y // 3)
    for i in range(a, a + 3):
        for j in range(b, b + 3):
            if (i, j) != (x, y) and board[i][j] == n:
                return 0
    return 1

def dfs(cnt, board, zero):
    if cnt == len(zero):
        return 1
    x, y = zero[cnt]
    flag = 0
    for num in range(1, 10):
        if check_lines(board, x, y, num) and check_box(board, x, y, num):
            flag = 1
            board[x][y] = num
            if dfs(cnt + 1, board, zero) == 0:
                   board[x][y] = 0
                   flag = 0
    return 1 if flag == 1 else 0

def print_board(board):
    for i in range(9):
        print(*board[i])

def sol():
    board = []
    zero = []
    for i in range(9):
        board.append(list(map(int, input().split())))
        for j in range(9):
            if board[i][j] == 0:
                zero.append((i, j))
    dfs(0, board, zero)
    print_board(board)

sol()