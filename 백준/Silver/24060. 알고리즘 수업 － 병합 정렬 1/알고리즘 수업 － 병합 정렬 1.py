import sys
input = lambda: sys.stdin.readline().rstrip()

def merge_sort(num):
    if len(num) == 1:
        return num
    
    mid = (len(num)+1) // 2
    left = merge_sort(num[:mid])
    right = merge_sort(num[mid:])
    i, j = 0, 0
    tmp = []
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            tmp.append(left[i])
            res.append(left[i])
            i += 1
        else:
            tmp.append(right[j])
            res.append(right[j])
            j += 1
    while i < len(left):
        tmp.append(left[i])
        res.append(left[i])
        i += 1
    while j < len(right):
        tmp.append(right[j])
        res.append(right[j])
        j += 1
    return tmp

if __name__ == '__main__':
    n, k = map(int, input().split())
    num = list(map(int, input().split()))
    res = []

    merge_sort(num)
    
    if len(res) >= k:
        print(res[k-1])
    else:
        print(-1)