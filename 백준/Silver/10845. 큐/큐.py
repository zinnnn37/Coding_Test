import sys

class Queue():
    def __init__(self):
        self.items = []
    def push(self, data):
        self.items.append(data)
    def pop(self):
        try:
            print(self.items.pop(0))
        except:
            print(-1)
    def size(self):
        print(len(self.items))
    def empty(self):
        if (self.items):
            print(0)
        else:
            print(1)
    def front(self):
        try:
            print(self.items[0])
        except:
            print(-1)
    def back(self):
        try:
            print(self.items[-1])
        except:
            print(-1)

n = int(input())
q = Queue()

for _ in range(n):
    data = sys.stdin.readline().strip().split()

    if (data[0] == 'push'):
        q.push(int(data[1]))
    elif (data[0] == 'empty'):
        q.empty()
    elif (data[0] == 'pop'):
        q.pop()
    elif (data[0] == 'size'):
        q.size()
    elif (data[0] == 'front'):
        q.front()
    elif (data[0] == 'back'):
        q.back()