def d(n):
    n = n + sum(map(int, str(n)))
    return n

def selfnum():
    constructor = set()
    for i in range(1, 10001):
        n = d(i)
        if (n <= 10000):
            constructor.add(d(i))
    for i in range(1, 10001):
        if i not in constructor:
            print(i)

selfnum()
