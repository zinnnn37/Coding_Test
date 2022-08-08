import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    S = input()
    length = len(S)
    q = int(input())
    alsum = {}
    for _ in range(q):
        a, l, r = input().split()
        l, r = int(l), int(r)
        if a not in alsum:
            alsum[a] = [0]
            [alsum[a].append(alsum[a][i-1] + int(a==S[i-1])) for i in range(1, length+1)]
        print(alsum[a][r+1] - alsum[a][l])

sol()