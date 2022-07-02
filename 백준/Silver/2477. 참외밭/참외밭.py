import sys
input = sys.stdin.readline

def sol():
    k = int(input())
    length = [list(map(int, input().split())) for _ in range(6)]
    w, idx_w = 0, 0
    h, idx_h = 0, 0
    for i in range(6):
        if length[i][0] <= 2:
            if w < length[i][1]:
                w = length[i][1]
                idx_w = i
        else:
            if h < length[i][1]:
                h = length[i][1]
                idx_h = i
    small_w = abs(length[(idx_w-1) % 6][1] - length[(idx_w+1) % 6][1])
    small_h = abs(length[(idx_h-1) % 6][1] - length[(idx_h+1) % 6][1])
    print((w*h - small_w*small_h) * k)
    
sol()