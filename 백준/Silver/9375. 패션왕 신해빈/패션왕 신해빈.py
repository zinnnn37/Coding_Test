from functools import reduce
from collections import defaultdict
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    for _ in range(int(input())):
        style = defaultdict(int)
        for _ in range(int(input())):
            clothes = input().split()
            style[clothes[1]] += 1
        if (len(style) == 0):
            print(0)
        elif (len(style) == 1):
            print(*style.values())
        else:
            print(eval("*".join([str(n+1) for n in style.values()])) - 1)

sol()