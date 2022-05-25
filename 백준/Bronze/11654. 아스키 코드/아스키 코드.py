def ascii(c):
    if ((c >= 'a' and c <= 'z') or (c >= 'A' and c <= 'Z')
        or (c >= '0' and c <= '9')):
        print(ord(c))

ascii(input())