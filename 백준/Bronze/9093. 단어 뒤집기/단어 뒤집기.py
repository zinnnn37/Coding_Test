n = int(input())

for _ in range(n):
    st = input().split()
    res = []
    
    for s in st:
        res.append(s[::-1])
    print(" ".join(res))