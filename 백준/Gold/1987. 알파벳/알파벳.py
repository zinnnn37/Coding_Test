import sys
input = lambda: sys.stdin.readline().rstrip()

def bfs():
    global cnt
    q = set([(0, 0, alpha[0][0])])
    while q:
        x, y, z = q.pop()
        cnt = max(cnt, len(z))
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and alpha[nx][ny] not in z:
                q.add((nx, ny, alpha[nx][ny] + z))

if __name__ == '__main__':
    h, w = map(int, input().split())
    alpha = [list(input()) for _ in range(h)]
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    cnt = 1
    bfs()
    print(cnt)