n  = int(input())
# 리스트 생성 1
m = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] for _ in range(n + 2)]

m[1]= [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
for index in range(1, n):
    for j in range(1, 10):
        m[index + 1][j] = m[index][j-1] + m[index][j+1]
        m[index + 1][0] = m[index][1]
print(sum(m[n][1:]) % 1000000000)
