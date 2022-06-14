import collections
import sys

def statistics(n, arr):
    arr.sort()

    # 산술 평균
    sys.stdout.write(str(round(sum(arr) / n)) + '\n')

    # 중앙값
    sys.stdout.write(str(arr[n // 2]) + '\n')

    # 최빈값
    counts = collections.Counter(arr).most_common(2)
    if len(counts) == 2 and counts[0][1] > counts[1][1]:
        sys.stdout.write(str(counts[0][0]) + '\n')
    else:
        sys.stdout.write(str(counts[-1][0]) + '\n')

    # 범위
    sys.stdout.write(str(max(arr) - min(arr)) + '\n')

n = int(input())
arr = [int(sys.stdin.readline()) for _ in range(n)]
statistics(n, arr)
