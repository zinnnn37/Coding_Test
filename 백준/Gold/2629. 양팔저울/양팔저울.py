import sys, math
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    pendulum = list(map(int, input().split()))
    val = sum(pendulum)
    dp = [[False] * (val + 1) for _ in range(n)]
    dp[0][0], dp[0][pendulum[0]] = True, True
    for i in range(1, n):
        for j in range(val + 1):
            if dp[i-1][j]:
                dp[i][j] = True
                dp[i][j + pendulum[i]] = True
    s = set()
    for i in range(n):
        for j in range(val + 1):
            if dp[i][j]:
                s.add(j)

    m = int(input())
    bead = list(map(int, input().split()))
    for b in bead:
        valid = False
        for p in s:
            if p - b in s:
                valid = True
                break
        print('Y' if valid else 'N', end=' ') 

sol()