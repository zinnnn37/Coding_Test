def fibo(n, f):
    for i in range(2, n + 1):
        f.append(f[i-2] + f[i-1])

    print(f[n])

n = int(input())
f = [0, 1]
fibo(n, f)
