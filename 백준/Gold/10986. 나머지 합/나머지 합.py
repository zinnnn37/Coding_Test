import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, m = map(int, input().split())
    num = list(map(int, input().split()))
    mod = [0] * m
    psum = 0
    for i in range(n):
        psum += num[i]
        mod[psum % m] += 1
    cnt = mod[0]
    for i in mod:
        cnt += i * (i-1) // 2
    print(cnt)

sol()