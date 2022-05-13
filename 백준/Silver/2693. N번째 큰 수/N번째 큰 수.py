n = int(input())
for _ in range(n):
    lst = list(map(int, input().split()))
    lst.sort()
    print(lst[7])
