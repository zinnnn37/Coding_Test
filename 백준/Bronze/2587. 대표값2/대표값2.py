import sys
input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    num = [int(input()) for _ in range(5)]
    num.sort()
    print(sum(num)//5)
    print(num[2])