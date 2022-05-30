def factorization(n):
    div = 2
    while (n != 1):
        if (n % div == 0):
            n = n // div
            print(div)
        else:
            div += 1

factorization(int(input()))