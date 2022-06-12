import sys

n = int(input())
arr = [int(sys.stdin.readline()) for _ in range(n)]

for i in sorted(arr):
    sys.stdout.write(str(i) + '\n')