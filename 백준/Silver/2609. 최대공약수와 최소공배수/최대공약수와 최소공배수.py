def gcd(n, m):
    if (m == 0):
        return (n)
    if (n > m):
        return gcd(m, n % m)
    else:
        return gcd(n, m % n)

def lcm(n, m, g):
    return (int(n * m / g))

n, m = map(int, input().split())
g = gcd(n, m)
print(g)
print(lcm(n, m, g))
