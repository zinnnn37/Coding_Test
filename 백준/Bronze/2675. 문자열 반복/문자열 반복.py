n = int(input())

for i in range(n):
    a = input().split()
    for c in a[1]:
        for j in range(int(a[0])):
            print(c,end='')
    print()
