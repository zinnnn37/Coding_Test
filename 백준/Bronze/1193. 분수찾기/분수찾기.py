def fraction(n):
    k = 1
    line = 1
    while (n > k):
        line += 1
        k += line
    gap = k - n
    if (line % 2 == 0):
        print(line-gap, '/', gap+1, sep='')
    else:
        print(gap+1, '/', line-gap, sep='')

fraction(int(input()))