import sys

class Deque:
    def __init__(self):
        self.items = []
    def push_front(self, data):
        self.items.insert(0, data)
    def push_back(self, data):
        self.items.append(data)
    def pop_front(self):
        try:
            print(self.items.pop(0))
        except:
            print(-1)
    def pop_back(self):
        try:
            print(self.items.pop())
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
d = Deque()

for _ in range(n):
    data = sys.stdin.readline().strip().split()

    if (data[0] == 'push_front'):
        d.push_front(int(data[1]))
    elif (data[0] == 'push_back'):
        d.push_back(int(data[1]))
    elif (data[0] == 'pop_front'):
        d.pop_front()
    elif (data[0] == 'pop_back'):
        d.pop_back()
    elif (data[0] == 'size'):
        d.size()
    elif (data[0] == 'empty'):
        d.empty()
    elif (data[0] == 'front'):
        d.front()
    elif (data[0] == 'back'):
        d.back()