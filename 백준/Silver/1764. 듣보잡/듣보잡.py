import sys
input = sys.stdin.readline

m, n = map(int, input().split())
lst = dict()
for i in range(m):
    lst[input().strip()] = 1
cnt = 0
ans = []
for i in range(n):
    user = input().strip()
    try:
        lst[user]
        ans.append(user)
        cnt += 1
    except:
        continue
print(cnt)
print('\n'.join(sorted(ans)))