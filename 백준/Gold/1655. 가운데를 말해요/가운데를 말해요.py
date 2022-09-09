import heapq
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    left = []
    right = []
    for _ in range(int(input())):
        if len(left) == len(right):
            heapq.heappush(left, -int(input()))
        else:
            heapq.heappush(right, int(input()))
        if right and -left[0] > right[0]:
            min = heapq.heappop(right)
            max = -heapq.heappop(left)
            heapq.heappush(left, -min)
            heapq.heappush(right, max)
        print(-left[0])

sol()