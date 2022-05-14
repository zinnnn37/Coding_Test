def bigger(n):
    cnt = 1
    for i in range(n):
        print(' '*(n-i-1), end='')
        print('*'*cnt)
        cnt += 2

def smaller(n):
    cnt = n*2-3
    for i in range(n-1):
        print(' '*(i+1), end='')
        print('*'*cnt)
        cnt -= 2

n = int(input())

bigger(n)
smaller(n)