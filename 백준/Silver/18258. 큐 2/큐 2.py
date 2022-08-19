import sys
input = lambda: sys.stdin.readline().strip()

class Queue:
    def __init__(self, n):
        self.queue = [None] * n
        self.front = 0
        self.rear = 0
        self.size = 0
        self.maximum = n
    def push(self, val):
        self.queue[self.rear] = val
        self.rear = (self.rear + 1) % self.maximum
        self.size += 1
    def pop(self):
        if self.size == 0:
            return -1
        res = self.queue[self.front]
        self.front = (self.front + 1) % self.maximum
        self.size -= 1
        return res
    def getsize(self):
        return self.size
    def empty(self):
        if self.size == 0:
            return 1
        return 0
    def getfront(self):
        if self.size == 0:
            return -1
        return self.queue[self.front]
    def back(self):
        if self.size == 0:
            return -1
        return self.queue[(self.rear - 1) % self.maximum]

def sol():
    n = int(input())
    q = Queue(n)
    for _ in range(n):
        cmd = input().split()
        if cmd[0] == 'push':
            q.push(cmd[1])
        elif cmd[0] == 'pop':
            print(q.pop())
        elif cmd[0] == 'size':
            print(q.getsize())
        elif cmd[0] == 'empty':
            print(q.empty())
        elif cmd[0] == 'front':
            print(q.getfront())
        elif cmd[0] == 'back':
            print(q.back())

sol()