import sys
input = sys.stdin.readline

if __name__ == '__main__':
    n = int(input())
    
    while (n > 0):
        n -= 4
        print("long", end=" ")
    
    print("int")