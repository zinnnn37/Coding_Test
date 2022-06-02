from sys import stdin
def building(k, n):
    cnt = [i for i in range(1, n+1)]
    for i in range(k):
        for j in range(1, n):
            cnt[j] += cnt[j-1]
    print(cnt[-1])

T = int(stdin.readline())
for i in range(T):
    k = int(stdin.readline())
    n = int(stdin.readline())
    building(k, n)
