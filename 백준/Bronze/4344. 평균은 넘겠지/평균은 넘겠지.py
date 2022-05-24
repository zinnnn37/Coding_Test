def getAvg(arr):
    return sum(arr) / len(arr)

def average(arr):
    avg = getAvg(arr[1:])
    cnt = 0
    for i in range(1, arr[0] + 1):
        if (arr[i] > avg):
            cnt += 1
    print('%.3f%%'% (cnt / arr[0] * 100))

for i in range(int(input())):
    arr = list(map(int, input().split()))
    average(arr)