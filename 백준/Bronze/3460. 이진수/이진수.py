def binary(n):
    cnt = 0
    mod = 0
    while (n > 0):
        mod = n % 2
        if (mod == 1):
            print('%d' %cnt, end=' ')
        cnt += 1
        n = n // 2
    print()

n = int(input())
for i in range(n):
    binary(int(input()))
