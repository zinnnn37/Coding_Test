def div(lst):
    return (max(lst) * min(lst))

n = int(input())
lst = list(map(int, input().split()))
print(div(lst))
