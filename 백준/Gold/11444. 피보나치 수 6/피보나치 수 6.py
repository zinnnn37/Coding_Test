import sys
input = lambda: sys.stdin.readline().strip()

def mat_mul(a, b):
    tmp = [[0, 0] for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                tmp[i][j] += a[i][k] * b[k][j]
            tmp[i][j] %= 1000000007
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
    n = int(input())
    base = [[1, 1], [1, 0]]
    print(mat_pow(base, n)[0][1])

sol()