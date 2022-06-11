def bubble(n, arr):
    for i in range(n - 1, 0, -1):
        changed = False
        for j in range(i):
            if (arr[j] > arr[j + 1]):
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                changed = True
        if not changed: break
    print('\n'.join(map(str, arr)))

n = int(input())
arr = [int(input()) for i in range(n)]
bubble(n, arr)