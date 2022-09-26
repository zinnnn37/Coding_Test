import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n, l = map(int, input().split())
    for length in range(l, 101):
        x = n - (length * (length + 1) // 2)
        if x % length == 0:
            x = x // length

            if x >= -1:
                for j in range(1, length+1):
                    print(x + j, end=' ')
                break
    else:
        print(-1)

sol()