def ox(str):
    cnt = 0
    res = 0
    for c in str:
        if (c == 'O'):
            cnt += 1
            res += cnt
        else:
            cnt = 0
    print(res)

for i in range(int(input())):
    ox(input())
