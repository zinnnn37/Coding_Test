import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, c = map(int, input().split())
    house = [int(input()) for _ in range(n)]
    house.sort()
    start, end = 1, max(house) - 1
    while start <= end:
        mid = (start + end) // 2
        cnt = 1
        wifi = min(house) + mid
        for i in range(1, len(house)):
            if house[i] >= wifi:
                cnt += 1
                wifi = house[i] + mid
        if cnt >= c:
            start = mid + 1
        else:
            end = mid - 1
    print(end)

sol()