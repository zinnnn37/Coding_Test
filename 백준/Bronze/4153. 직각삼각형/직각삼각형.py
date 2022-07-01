import sys
input = sys.stdin.readline

def sol():
    while True:
        arr = sorted(list(map(int, input().split())))
        if min(arr) == max(arr) == 0:
            break
        if min(arr) <= 0:
            print('wrong')
        elif pow(arr[0], 2) + pow(arr[1], 2) == pow(arr[2], 2):
            print('right')
        else:
            print('wrong')

sol()