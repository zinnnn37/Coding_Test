def d(n):
    for i in range(1, 1000001):
        arr = list(map(int, list(str(i))))
        if (n == i + sum(arr)):
            print(i)
            return
    print(0)
    return

d(int(input()))