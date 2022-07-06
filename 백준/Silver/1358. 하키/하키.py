import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    w, h, x, y, p = map(int, input().split())
    r = h//2
    cnt = 0
    for _ in range(p):
        px, py = map(int, input().split())
        if x <= px <= x+w and y <= py<= y+h:
            cnt += 1
        elif (px-x)**2 + (py-(y+r))**2 <= r**2:
            cnt += 1
        elif (px-(x+w))**2 + (py-(y+r))**2 <= r**2:
            cnt += 1
    print(cnt)
    
sol()