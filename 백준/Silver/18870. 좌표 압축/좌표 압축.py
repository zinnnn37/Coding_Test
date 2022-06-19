import sys
input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
arr = list(map(int, input().split()))
s = sorted(list(set(arr)))
s = {s[i] : i for i in range(len(s))}

for i in arr:
    print(str(s[i]) + ' ')