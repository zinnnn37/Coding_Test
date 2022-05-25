n, m = input().split()
n = "".join(reversed(n))
m = "".join(reversed(m))

if (n > m):
    print(n)
else:
    print(m)