def ACM(h, n):
    y = n % h
    if (y == 0):
        y = h
        x = n // h
    else:
        x = n // h + 1
        
    print("%d"%(y * 100 + x))

for i in range(int(input())):
    a, b, c = map(int, input().split())
    ACM(a, c)
