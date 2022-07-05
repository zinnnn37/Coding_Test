import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    for _ in range(int(input())):
        x1, y1, x2, y2 = map(int, input().split())
        cnt = 0
        
        for _ in range(int(input())):
            cx, cy, r = map(int, input().split())
            d1 = (x1-cx)**2 + (y1-cy)**2
            d2 = (x2-cx)**2 + (y2-cy)**2

            if (d1 < r**2 and d2 > r**2) or (d1 > r**2 and d2 < r**2):
                cnt += 1
        print(cnt)

sol()