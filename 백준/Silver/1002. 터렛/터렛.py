import sys
input = sys.stdin.readline

def sol():
    for _ in range(int(input())):
        x1, y1, r1, x2, y2, r2 = map(int, input().split())
        dis = (x1-x2)**2 + (y1-y2)**2
        if dis == 0 and r1 == r2:
            print(-1)
        elif (r1-r2)**2 == dis or (r1+r2)**2 == dis:
            print(1)
        elif (r1-r2)**2 < dis < (r1+r2)**2:
            print(2)
        else:
            print(0)

sol()