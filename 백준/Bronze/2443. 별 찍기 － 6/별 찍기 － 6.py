n = int(input())
cnt = n*2-1

for i in range(n):
    print(' '*i, end='')
    print('*'*cnt)
    cnt -= 2