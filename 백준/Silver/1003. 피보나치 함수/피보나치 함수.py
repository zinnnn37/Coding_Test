def fibo(n, z, o):
    for i in range(2, n+1):
        z.append(z[i-2] + z[i-1])
        o.append(o[i-2] + o[i-1])
    print(z[n], o[n])

for _ in range(int(input())):
    z = [1, 0]
    o = [0, 1]
    fibo(int(input()), z, o)
