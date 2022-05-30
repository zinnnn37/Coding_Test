def prime(a):
    cnt = 0
    for num in a:
        if (num < 2):
            flag = 0
            continue
        flag = 1
        i = 2
        while (i * i <= num):
            if (num % i == 0):
                flag = 0
            i += 1
        if (flag == 1):
            cnt += 1
    print(cnt)

n = int(input())
prime(list(map(int, input().split())))