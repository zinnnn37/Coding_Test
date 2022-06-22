import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lst_num = dict()
for i in range(n):
    lst_num[i + 1] = input().strip()
lst_name = {v: k for k, v in lst_num.items()}

for _ in range(m):
    user = input().strip()
    if user.isdecimal():
        print(lst_num[int(user)])
    else:
        print(lst_name[user])