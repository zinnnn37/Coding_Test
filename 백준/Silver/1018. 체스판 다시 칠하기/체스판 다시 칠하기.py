import sys
input = sys.stdin.readline

def board(n, m, matrix):
    cnt = []
    for i in range(n - 7):
        for j in range(m - 7):
            cnt1 = 0
            cnt2 = 0
            for a in range(i, i + 8):
                for b in range(j, j + 8):
                    if ((a + b) % 2 == 0):
                        if (matrix[a][b] != 'W'):
                            cnt1 += 1
                        else:
                            cnt2 += 1
                    else:
                        if (matrix[a][b] != 'B'):
                            cnt1 += 1
                        else:
                            cnt2 += 1
            cnt.append(min(cnt1, cnt2))
    print(min(cnt))

n, m = map(int, input().split())
matrix = [input().rstrip() for i in range(n)]
board(n, m, matrix)
