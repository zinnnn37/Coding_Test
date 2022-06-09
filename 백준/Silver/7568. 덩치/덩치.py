from sys import stdin
def ranking(n, arr):
    for i in arr:
        rank = 1
        for j in arr:
            if (i[0] < j[0] and i[1] < j[1]):
                rank += 1
        print(rank, end=' ')

n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, stdin.readline().split())))
ranking(n, arr)