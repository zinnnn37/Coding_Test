import sys

words = set()
for _ in range(int(input())):
    words.add(sys.stdin.readline().rstrip())
words = list(words)
words.sort(key=lambda x : (len(x), x))
print('\n'.join(words))