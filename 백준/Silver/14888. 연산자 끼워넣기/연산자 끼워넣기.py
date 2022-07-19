import sys
input = lambda: sys.stdin.readline().strip()

max_n = -1e9
min_n = 1e9

def dfs(n, nums, i, total, add, minus, mul, div):
    global max_n, min_n
    
    if (i == n):
        max_n = max(total, max_n)
        min_n = min(total, min_n)
        return
        
    if add:
        dfs(n, nums, i + 1, total + nums[i], add - 1, minus, mul, div)
    if minus:
        dfs(n, nums, i + 1, total - nums[i], add, minus - 1, mul, div)
    if mul:
        dfs(n, nums, i + 1, total * nums[i], add, minus, mul - 1, div)
    if div:
        dfs(n, nums, i + 1, int(total / nums[i]), add, minus, mul, div - 1)

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    ops = list(map(int, input().split()))
    dfs(n, nums, 1, nums[0], ops[0], ops[1], ops[2], ops[3])
    print(max_n)
    print(min_n)
    
sol()