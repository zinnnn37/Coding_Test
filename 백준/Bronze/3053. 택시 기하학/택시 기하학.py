import math
import sys
input = sys.stdin.readline

def sol():
    n = float(input())
    print(f"{n**2*math.pi:.6f}")
    print(f"{n**2*2:.6f}")

sol()