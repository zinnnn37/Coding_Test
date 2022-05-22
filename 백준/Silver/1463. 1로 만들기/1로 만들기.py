def _one(n, lst):
    if (n == 1):
        return 0
    elif (lst[n]):
        return lst[n]
    else:
        if (n % 6 == 0):
            lst[n] = min(_one(n//2, lst), _one(n//3, lst)) + 1
        elif (n % 3 == 0):
            lst[n] = min(_one(n//3, lst), _one(n-1, lst)) + 1
        elif (n % 2 == 0):
            lst[n] = min(_one(n//2, lst), _one(n-1, lst)) + 1
        else:
            lst[n] = _one(n-1, lst) + 1
        return lst[n]

def one(n):
    a = [0 for _ in range(n+1)]
    print(_one(n, a))

one(int(input()))
