import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    dx = [1, -1, 0, 0, 1, -1, 1, -1]
    dy = [0, 0, -1, 1, 1, 1, -1, -1]
    move = ['R', 'L', 'B', 'T', 'RT', 'LT', 'RB', 'LB']
    alpha = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
    king, stone, n = input().split()
    kpos = [alpha.index(king[0]), int(king[1])]
    spos = [alpha.index(stone[0]), int(stone[1])]

    for _ in range(int(n)):
        case = move.index(input())
        nx = kpos[0] + dx[case]
        ny = kpos[1] + dy[case]

        if nx < 0 or nx > 7 or ny < 1 or ny > 8:
            continue
        if nx == spos[0] and ny == spos[1]:
            cx = spos[0] + dx[case]
            cy = spos[1] + dy[case]

            if cx < 0 or cx > 7 or cy < 1 or cy > 8:
                continue
            spos[0] = cx
            spos[1] = cy

        kpos[0] = nx
        kpos[1] = ny

    print(alpha[kpos[0]] + str(kpos[1]))
    print(alpha[spos[0]] + str(spos[1]))

sol()