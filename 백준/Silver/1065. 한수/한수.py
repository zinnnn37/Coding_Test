def check(n):
    if (n < 100):
        return (n)
    else:
        if (n == 1000):
            n -= 1
        cnt = 0
        for i in range(100, n+1):
            cnt += sequence(i, i//10)
        return (cnt + 99)
    
def sequence(n, m):
    if (m // 10 == 0):
        return n%10 - m
    else:
        res = sequence(n//10, m//10)
    if (res == n%10-m%10):
        return (1)
    else:
        return (0)
        
print(check(int(input())))
