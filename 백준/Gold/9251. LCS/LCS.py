import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    s1 = input()
    s2 = input()
    l1 = len(s1)
    l2 = len(s2)
    matrix = [[0] * (l2 + 1) for _ in range(l1 + 1)]
    for i in range(1, l1+1):
        for j in range(1, l2+1):
            if s1[i-1] == s2[j-1]:
                matrix[i][j] = matrix[i-1][j-1] + 1
            else:
                matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1])
    print(matrix[l1][l2])

sol()