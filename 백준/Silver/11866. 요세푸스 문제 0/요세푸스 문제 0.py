from collections import deque
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, k = map(int, input().split())
    q = deque()
    res = []
    for i in range(n):
        q.append(i+1)
    while q:
        for i in range(k):
            if i == k-1:
                res.append(q.popleft())
            else:
                q.append(q.popleft())
    print('<' + ', '.join(map(str, res)) + '>')

sol()