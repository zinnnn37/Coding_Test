def check_alpha(str):
    alpha = [-1 for _ in range(26)]

    for i in range(len(str)):
        if (alpha[ord(str[i]) - 97] == -1):
            alpha[ord(str[i]) - 97] = i

    for i in alpha:
        print(i, end=' ')

str = input()
check_alpha(str)
