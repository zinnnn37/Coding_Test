import sys
input = sys.stdin.readline

def sol():
    k = int(input())
    length = [list(map(int, input().split()))[1] for _ in range(6)]
    max_idx1 = length.index(max(length))
    max_idx2 = length.index(max(length[(max_idx1-1) % 6], length[(max_idx1+1) % 6]))
    small1 = abs(length[(max_idx1-1) % 6] - length[(max_idx1+1) % 6])
    small2 = abs(length[(max_idx2-1) % 6] - length[(max_idx2+1) % 6])
    print((length[max_idx1]*length[max_idx2] - small1*small2) * k)

sol()