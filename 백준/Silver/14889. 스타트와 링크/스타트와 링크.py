from itertools import combinations as comb
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    arr = [i for i in range(n)]
    matrix = [list(map(int, input().split())) for _ in range(n)]
    gap = 1e9

    for s in comb(arr, n//2):
        start, link = 0, 0
        l = list(set(arr) - set(s))
        for player in comb(s, 2):
            start += matrix[player[0]][player[1]]
            start += matrix[player[1]][player[0]]
        for player in comb(l, 2):
            link += matrix[player[0]][player[1]]
            link += matrix[player[1]][player[0]]
        gap = min(gap, abs(start - link))
    print(gap)

sol()