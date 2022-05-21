def sugar(n):
    res = 0

    while (n > 0):
        if (n % 5 == 0):
            res += (n // 5)
            print(res)
            return
        n -= 3
        res += 1
        
    if (n < 0):
        print(-1)
    else:
        print(res)

n = int(input())
sugar(n)
