def sugar(n):
    if (n < 3 or n == 4):
        print(-1)
        return
    arr = [-1 for _ in range(n+1)]
    if (n == 3):
        print(1)
        return
    else:
        arr[3] = arr[5] = 1

    for i in range(6, n+1):
        min = n
        for j in range(1, i // 2 + 1):
            if (arr[j] != -1 and arr[i-j] != -1):
                if (min > arr[j] + arr[i-j]):
                    min = arr[j] + arr[i-j]
        if (min != n):
            arr[i] = min
    print(arr[n])

n = int(input())
sugar(n)
