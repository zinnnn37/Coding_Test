import sys
input = sys.stdin.readline

def bisect(left, right, target, has):
    while left < right:
        mid = (left + right) // 2

        if has[mid] < target:
            left = mid + 1
        elif has[mid] > target:
            right = mid
        else:
            return 1
    return 0

def find_cards(left, right, has, cards):
    for c in cards:
        print(bisect(left, right, c, has), end=' ')

m = int(input())
has = sorted(list(map(int, input().split())))
n = int(input())
cards = list(map(int, input().split()))

find_cards(0, m, has, cards)