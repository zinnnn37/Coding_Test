import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x : (x[1], x[0]))
for lst in arr:
    print(lst[0], lst[1])