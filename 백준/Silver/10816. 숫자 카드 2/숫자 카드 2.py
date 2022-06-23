import sys
from collections import Counter
input = sys.stdin.readline

def sol():
    input()
    cards_have = Counter(input().split())
    input()
    cards_check = [cards_have[i] for i in input().split()]
    print(' '.join(map(str, cards_check)))

sol()