from collections import deque
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    d = deque()
    for i in range(int(input())):
        d.append(i + 1)
    while len(d) != 1:
        d.popleft()
        if len(d) == 1:
            break
        d.append(d.popleft())
    print(*d)

sol()