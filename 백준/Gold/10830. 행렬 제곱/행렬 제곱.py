import sys
input = lambda: sys.stdin.readline().strip()

def mat_mul(a, b):
    length = len(a)
    tmp = [[0] * length for _ in range(length)]
    for i in range(length):
        for j in range(length):
            for k in range(length):
                tmp[i][j] += a[i][k] * b[k][j]
            tmp[i][j] %= 1000
    return tmp

def mat_pow(matrix, n):
    if n == 1:
        return matrix
    if n % 2 == 0:
        tmp = mat_pow(matrix, n//2)
        return mat_mul(tmp, tmp)
    else:
        tmp = mat_pow(matrix, n-1)
        return mat_mul(tmp, matrix)

def sol():
    n, b = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    res = mat_pow(matrix, b)
    for row in res:
        for num in row:
            print(num % 1000, end=' ')
        print()

sol()