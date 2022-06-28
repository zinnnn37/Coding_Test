import sys
input = sys.stdin.readline

def sol():
    input()
    A = set(map(int, input().split()))
    B = set(map(int, input().split()))
    print(len(A-B) + len(B-A))
    
sol()