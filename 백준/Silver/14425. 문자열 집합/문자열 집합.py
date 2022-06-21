import sys
input = sys.stdin.readline

n, m = map(int, input().split())
s = [''] * n
cnt = 0
for i in range(n):
    s[i] = input()
for i in range(m):
    if input() in s:
        cnt += 1

print(cnt)