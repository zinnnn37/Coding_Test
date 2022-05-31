def prime(n):
    if (n < 2):
        return 0
    i = 2
    while (i * i <= n):
        if (n % i == 0):
            return 0
        i += 1
    return 1

m, n = map(int, input().split())

for i in range(m, n+1):
    if (prime(i) == 1):
        print(i)