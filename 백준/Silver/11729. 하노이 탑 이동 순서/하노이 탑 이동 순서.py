def hanoi(n, source, dest, temp):
    if (n == 1):
        print(source, dest)
    else:
        hanoi(n-1, source, temp, dest)
        print(source, dest)
        hanoi(n-1, temp, dest, source)

n = int(input())
print(2**n-1)
hanoi(n, 1, 3, 2)