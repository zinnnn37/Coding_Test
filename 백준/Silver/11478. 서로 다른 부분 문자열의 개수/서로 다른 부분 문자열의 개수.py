import sys
input = sys.stdin.readline

def sol():
    res = set()
    s = input().strip()
    for i in range(len(s)):
        left = i
        for j in range(i+1, len(s)+1):
            res.add(s[i:j])
    print(len(res))

sol()