def caesar(str):
    for c in str:
        if (c >= 'A' and c <= 'C'):
            c = chr(ord(c) + 23)
            print(c, end='')
        else:
            print(chr(ord(c) - 3), end='')

str = input()

caesar(str)
