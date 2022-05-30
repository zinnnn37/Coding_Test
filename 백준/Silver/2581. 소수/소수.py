def prime(n):
    if (n < 2):
        return 0
    i = 2
    while (i * i <= n):
        if (n % i == 0):
            return 0
        i += 1
    return 1

def findPrime(m, n):
    min = n
    res = 0
    for i in range(m, n + 1):
        if (prime(i) == 1):
            if (min > i):
                min = i
            res += i
    if (res == 0):
        print(-1)
    else:
        print("%d\n%d"%(res, min))

m, n = list(map(int, (input() for _ in range(2))))
findPrime(m, n)