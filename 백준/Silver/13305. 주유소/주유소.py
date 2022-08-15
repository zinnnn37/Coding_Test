import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    dist = list(map(int, input().split()))
    price = list(map(int, input().split()))
    lowest = price[0]
    cnt = price[0] * dist[0]
    for i in range(1, n-1):
        if lowest > price[i]:
            lowest = price[i]
        cnt += lowest * dist[i]
    print(cnt)

sol()