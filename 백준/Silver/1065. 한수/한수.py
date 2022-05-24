def seq(n):
    if (n < 100):
        return n
    else:
        cnt = 99
        for i in range(100, n+1):
            a = list(map(int, str(i)))
            if (a[0] - a[1] == a[1] - a[2]):
                cnt += 1
        return cnt

print(seq(int(input())))