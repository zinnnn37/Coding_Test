import heapq
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    h = []
    for _ in range(n):
        num = int(input())
        if num == 0:
            try:
                print(-heapq.heappop(h))
            except:
                print(0)
        else:
            heapq.heappush(h, -num)

sol()