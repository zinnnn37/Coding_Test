import sys

class Stack:
    def __init__(self):
        self.items = []
    def empty(self):
        return (len(self.items) == 0)
    def push(self, data):
        self.items.append(data)
    def size(self):
        return len(self.items)
    def top(self):
        try:
            print(self.items[-1])
        except:
            print('-1')
    def pop(self):
        try:
            print(self.items.pop())
        except:
            print('-1')

n = int(input())
s = Stack()

for i in range(n):
    data = sys.stdin.readline().strip().split()
    
    if (data[0] == 'push'):
        s.push(int(data[1]))
    elif (data[0] == 'empty'):
        print(int(s.empty()))
    elif (data[0] == 'top'):
        s.top()
    elif (data[0] == 'pop'):
        s.pop()
    elif (data[0] == 'size'):
        print(s.size())