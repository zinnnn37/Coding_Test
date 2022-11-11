import sys
input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def dfs(x, y, h):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0 and building[nx][ny] > h:
            visited[nx][ny] = 1
            dfs(nx, ny, h)

if __name__ == '__main__':
    n = int(input())
    building = [list(map(int, input().split())) for _ in range(n)]
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    res = 1
    for k in range(max(map(max, building))):
        visited = [[0]*n for _ in range(n)]
        cnt = 0
        for i in range(n):
            for j in range(n):
                if building[i][j] > k and visited[i][j] == 0:
                    cnt += 1
                    visited[i][j] = 1
                    dfs(i, j, k)
        res = max(res, cnt)
    print(res)