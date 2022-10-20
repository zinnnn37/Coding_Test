from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs(start, end):
    q = deque([start])
    visited[start] = 0
    
    while q:
        cur = q.popleft()
        if cur == end:
            return visited[cur]
        for nx in [cur*2, cur-1, cur+1]:
            if 0 <= nx <= 100000 and visited[nx] == -1:
                if nx != cur * 2:
                    visited[nx] = visited[cur] + 1
                else:
                    visited[nx] = visited[cur]
                q.append(nx)

if __name__ == '__main__':
    start, end = map(int, input().split())
    visited = [-1] * 100001
    print(bfs(start, end))