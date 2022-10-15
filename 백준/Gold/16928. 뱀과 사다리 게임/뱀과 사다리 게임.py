from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
ladder = dict()
snake = dict()
for _ in range(n):
    x, y = map(int, input().split())
    ladder[x] = y
for _ in range(m):
    u, v = map(int, input().split())
    snake[u] = v
board = [0] * 101

def bfs():
    q = deque([1])
    board[1] = 0
    
    while q:
        x = q.popleft()
        for i in range(1, 7):
            a = x + i
            if a <= 100 and board[a] == 0:
                if a in ladder.keys():
                    a = ladder[a]
                if a in snake.keys():
                    a = snake[a]
                if board[a] == 0:
                    q.append(a)
                    board[a] = board[x] + 1
    print(board[100])

bfs()