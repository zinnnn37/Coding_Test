import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    n = int(input())
    words = [input() for _ in range(n)]
    res = ''
    for i in range(len(words[0])):
        status = True
        for j in range(n-1):
            if words[j][i] != words[j+1][i]:
                status = False
                break
        if status:
            res += words[0][i]
        else:
            res += '?'
    print(res)

sol()