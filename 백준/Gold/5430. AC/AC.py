import re
import sys
input = lambda: sys.stdin.readline().strip()

def sol():
    for _ in range(int(input())):
        s = input()
        input()
        num = re.findall(r'\d+', input())
        flag = 1
        rev = 0
        for c in s:
            if c == 'R':
                rev += 1
            elif c == 'D':
                try:
                    if rev % 2 == 1:
                        num.pop()
                    else:
                        num.pop(0)
                except:
                    flag = 0
                    print('error')
                    break
        if flag:
            if rev % 2 == 1:
                print('[' + ','.join(reversed(num)) + ']')
            else:
                print('[' + ','.join(num) + ']')

sol()