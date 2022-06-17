n = int(input())
words = [input() for x in range(n)]
words = list(set(words))
words.sort(key=lambda x : (len(x), x))
print('\n'.join(words))