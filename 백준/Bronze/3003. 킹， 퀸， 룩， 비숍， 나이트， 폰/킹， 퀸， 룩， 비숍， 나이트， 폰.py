import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    piece = [1, 1, 2, 2, 2, 8]
    user = list(map(int, input().split()))
    for i in range(6):
        print(piece[i] - user[i], end=' ')

sol()