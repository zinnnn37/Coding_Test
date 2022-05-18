from collections import deque

def josephus(x, y):
    table = deque([i+1 for i in range(x)])
    res = []
    
    while (table):
        for i in range(y):
            if (i == y - 1):
                res.append(table.popleft())
            else:
                table.append(table.popleft())

    res = list(map(str, res))
    print('<' + ', '.join(res) + '>')


x, y = map(int, input().split())

josephus(x, y)
