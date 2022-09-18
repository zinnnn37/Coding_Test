import sys
input = lambda: sys.stdin.readline().rstrip()

def sol():
    for _ in range(int(input())):
        s = input()
        print(f'{s[0]}{s[-1]}')

sol()