def submul(num, cnt):
    i = 0
    while (i <= num):
        i += 1
        if (num % i == 0):
            cnt -= 1
        if (cnt == 0):
            print(i)
            return
    print('0')

num, cnt = input().split()
num, cnt = int(num), int(cnt)
submul(num, cnt)