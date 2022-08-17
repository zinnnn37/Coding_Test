import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    n = int(input())
    stack = []
    res = []
    maximum = 1
    
    for _ in range(n):
        m = int(input())
        if m >= maximum:
            while m > maximum:
                stack.append(maximum)
                res.append('+')
                maximum += 1
            maximum += 1
            res.append('+')
            res.append('-')
        else:
            while True:
                if len(stack) == 0:
                    print('NO')
                    return
                p = stack.pop()
                res.append('-')
                if p == m:
                    break

    print('\n'.join(res))
    
sol()