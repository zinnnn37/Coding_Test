import heapq
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    h = []
    for _ in range(int(input())):
        n = int(input())
        if n == 0:
            try:
                pop = heapq.heappop(h)
                print(pop[0]*pop[1])
            except:
                print(0)
        else:
            heapq.heappush(h, [abs(n)] + [1 if n >= 0 else -1])

sol()