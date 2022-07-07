import math
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = sorted(list(int(input()) for _ in range(n)))
    gap = []
    ans = []
    for i in range(1, n):
        gap.append(nums[i] - nums[i-1])
        
    g = gap[0]
    for i in range(1, n-1):
        g = math.gcd(g, gap[i])
        
    for i in range(2, int(math.sqrt(g)) + 1):
        if g % i == 0:
            ans.append(i)
            ans.append(g // i)
    ans.append(g)
    ans = list(set(ans))
    ans.sort()
    print(*ans)
        
sol()