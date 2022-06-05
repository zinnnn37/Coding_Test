def _star(arr):
    res = []
    length = len(arr)
    for i in range(length * 3):
        if i // length == 1:
            res.append(arr[i % length] + ' ' * length + arr[i % length])
        else:
            res.append(arr[i % length] * 3)
    return (res)

def star(n):
    arr = ["***", "* *", "***"]
    k = 0
    while (n != 3):
        n = n // 3
        k += 1
    for i in range(k):
        arr = _star(arr)
    for i in arr:
        print(i)

star(int(input()))