import math
def snail(a, b, c):
    print( math.ceil( (c-a) / (a-b) + 1 ) )

a, b, c = map(int, input().split())
snail(a, b, c)