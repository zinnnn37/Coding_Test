import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n, k = map(int, input().split())
    tem = list(map(int, input().split()))
    hap = [sum(tem[:k])]
    for i in range(1, n-k+1):
        hap.append(hap[i-1] - tem[i-1] + tem[i+k-1])
    print(max(hap))

sol()