def issqrt(n):
    i = 0
    while (i * i <= n):
        if (i * i == n):
            return 1
        i += 1
    return 0

def mult(n, m):
    min = -1
    res = 0
    for i in range(n, m+1):
        if (issqrt(i) == 1):
            res += i
            if (min == -1):
                min = i

    if (min != -1):
        print(res)
        print(min)
    else:
        print(min)

n = int(input())
m = int(input())
mult(n, m)
