import sys
input = lambda: sys.stdin.readline()

def sol():
    s = input()
    while (s != '.\n'):
        stack = []
        for c in s:
            if c == '.':
                if len(stack) == 0:
                    print('yes')
                else:
                    print('no')
                break
            elif c == '[' or c == '(':
                stack.append(c)
            elif c == ']' or c == ')':
                if len(stack) == 0:
                    print('no')
                    break
                elif c == ']':
                    if stack.pop() != '[':
                        print('no')
                        break
                else:
                    if stack.pop() != '(':
                        print('no')
                        break
        s = input()

sol()