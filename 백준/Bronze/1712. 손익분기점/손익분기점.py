def breakEvenPoint(a):
    if (a[1] >= a[2]):
        return -1
    return a[0] // (a[2] - a[1]) + 1

print(breakEvenPoint(list(map(int, input().split()))))