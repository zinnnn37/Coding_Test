def printer(n, m, pri):
    target = [0 for _ in range(n)]
    target[m] = 1
    o = 0
    while (True):
        if (pri[0] == max(pri)):
            o += 1
            if (not target[0]):
                pri.pop(0)
                target.pop(0)
            else:
                print(o)
                break;
        else:
            pri.append(pri.pop(0))
            target.append(target.pop(0))
            
a = int(input())

for i in range(a):
    n, m = map(int, input().split())
    priority = list(map(int, input().split()))

    printer(n, m, priority)
