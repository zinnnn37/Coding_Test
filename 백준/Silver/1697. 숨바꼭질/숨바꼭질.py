from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
sec = [0] * 100001

def bfs(n):
    q = deque()
    q.append(n)

    while q:
        x = q.popleft()
        if x == k:
            print(sec[x])
            break
        for nx in (x-1, x+1, 2*x):
            if 0 <= nx <= 100000 and sec[nx] == 0:
                sec[nx] = sec[x] + 1
                q.append(nx)

bfs(n)