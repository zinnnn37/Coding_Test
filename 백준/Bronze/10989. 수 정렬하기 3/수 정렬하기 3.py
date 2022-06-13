import sys

def sorting(n):
    cnt = [0] * 10001

    for _ in range(n):
        cnt[int(sys.stdin.readline())] += 1

    for i in range(10001):
        if cnt[i] != 0:
            while cnt[i] > 1000:
                    sys.stdout.write((str(i) + '\n') * 1000)
                    cnt[i] -= 1000
            sys.stdout.write((str(i) + '\n') * cnt[i])
n = int(input())
sorting(n)