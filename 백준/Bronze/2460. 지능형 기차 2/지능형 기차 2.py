res = 0
max = 0

for i in range(10):
    m, p = map(int, input().split())
    res -= m
    res += p
    if (res > max):
        max = res

print(max)
