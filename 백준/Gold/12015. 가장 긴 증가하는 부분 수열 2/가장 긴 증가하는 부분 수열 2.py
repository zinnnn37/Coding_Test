import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    nums = list(map(int, input().split()))
    memo = [0]
    for num in nums:
        if memo[-1] < num:
            memo.append(num)
        else:
            start = 0
            end = len(memo)
            while start < end:
                mid = (start+end) // 2
                if memo[mid] < num:
                    start = mid + 1
                else:
                    end = mid
            memo[end] = num
    print(len(memo) - 1)

sol()