def fibo(n, arr):
    for i in range(2, n+1):
        arr.append(arr[i-2] + arr[i-1])
    print(arr[n-1], arr[n])

for _ in range(int(input())):
    arr = [0, 1]
    fibo(int(input()), arr)
