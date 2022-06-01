from sys import stdin
def prime(n):
    if (n < 2):
        return 0
    i = 2
    while (i * i <= n):
        if (n % i == 0):
            return 0
        i += 1
    return 1

n = int(stdin.readline())
for i in range(n):
    num = int(stdin.readline())
    for j in range(num // 2, 1, -1):
        if (prime(j) == 1):
            if (prime(num-j) == 1):
                print(j, num-j)
                break