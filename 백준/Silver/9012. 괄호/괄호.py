import sys

def parentheses(p):
    res = []

    for c in p:
        if (c == '('):
            res.append(c)
        else:
            try:
                res.pop()
            except:
                print('NO')
                return
    if (res):
        print('NO')
    else:
        print('YES')

n = int(input())

for _ in range(n):
    p = list(sys.stdin.readline().strip())
    parentheses(p)

