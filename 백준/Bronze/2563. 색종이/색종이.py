import sys
input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    paper = [[0]*101 for _ in range(101)]
    ans = 0
    for _ in range(int(input())):
        x, y = map(int, input().split())
        for i in range(x, x+10):
            for j in range(y, y+10):
                if paper[i][j] == 0:
                    paper[i][j] = 1
                    ans += 1
    print(ans)