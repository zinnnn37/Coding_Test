import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    num = list(map(int, input().split()))
    stack = []
    ans = [-1] * n
    stack.append(0)
    for i in range(1, n):
        while stack and num[stack[-1]] < num[i]:
            ans[stack.pop()] = num[i]
        stack.append(i)
    print(*ans)

sol()