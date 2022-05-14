n = int(input())
cnt = 1

for i in range(n):
    print(' '*(n-i-1), end='')
    print('*'*cnt)
    cnt += 2