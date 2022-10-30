from collections import deque
from queue import Empty
import sys
input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    n = int(input())
    packet = int(input())
    q = deque([])
    size = 0
    while packet != -1:
        if packet == 0 and q:
            q.popleft()
            size -= 1
        elif size != n:
            q.append(packet)
            size += 1
        packet = int(input())
    print('empty' if not q else ' '.join(list(map(str, q))))