from collections import deque
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    m, n = map(int, input().split())
    num = list(map(int, input().split()))
    q = deque([i+1 for i in range(m)])
    cnt = 0
    for i in num:
        length = len(q)
        idx = q.index(i)
        if idx < length - idx:
            while q[0] != i:
                q.append(q.popleft())
                cnt += 1
            q.popleft()
        else:
            while q[0] != i:
                q.appendleft(q.pop())
                cnt += 1
            q.popleft()
    print(cnt)

sol()