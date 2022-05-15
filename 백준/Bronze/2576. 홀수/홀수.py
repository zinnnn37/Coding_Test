arr = list(map(int, (input() for _ in range(7))))

min = max(arr)
res = 0

for i in arr:
    if (i % 2 == 1):
        if (min > i):
            min = i
        res += i

if (res):
    print(res)
    print(min)
else:
    print(-1)
