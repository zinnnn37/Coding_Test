import sys
from collections import defaultdict
input = sys.stdin.readline

def sol():
    m = int(input())
    cards_have = list(map(int, input().split()))
    n = int(input())
    cards_check = list(map(int, input().split()))
    
    checker = defaultdict(int)
    for i in cards_have:
        checker[i] += 1

    for i in cards_check:
        print(checker[i], end=' ')

sol()