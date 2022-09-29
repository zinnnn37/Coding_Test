import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n, m = map(int, input().split())
    six = [0] * m
    one = [0] * m
    for i in range(m):
        s, o = map(int, input().split())
        six[i] = s
        one[i] = o
    s = min(six)
    o = min(one)
    print(min(n//6 * s + n%6 * o, (n//6 + 1) * s, n * o))

sol()