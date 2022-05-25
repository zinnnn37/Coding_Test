def dial(w):
    sec = 0
    d = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

    for c in w:
        for a in d:
            if c in a:
                sec += d.index(a) + 3
    print(sec)

dial(input())
