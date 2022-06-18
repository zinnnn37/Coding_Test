arr = []
for _ in range(int(input())):
    m, n = input().split()
    arr.append([int(m), n])

arr.sort(key=lambda x : x[0])
for data in arr:
    print(' '.join(map(str, data)))