def sol():
    n = int(input())
    i = 1
    res = 1
    state = 1
    while res <= n:
        i += 1
        res += i
        state += 1
    if state % 2 == 0:
        print(0)
    else:
        print(res-n)

sol()