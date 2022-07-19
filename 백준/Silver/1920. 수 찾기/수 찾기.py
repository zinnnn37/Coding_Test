import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    input()
    nums = set(input().split())
    input()
    check = input().split()
    for n in check:
        if n in nums:
            print(1)
        else:
            print(0)
sol()