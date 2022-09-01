import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    while True:
        user = list(map(int, input().split())) + [0]
        n = user[0]
        if n == 0:
            break
        stack = [[1, user[1]]]
        res = 0
        for i in range(2, n+2):
            w = i
            while stack and stack[-1][1] >= user[i]:
                w, hight = stack.pop()
                res = max(res, (i-w)*hight)
            stack.append([w, user[i]])
        print(res)

sol()