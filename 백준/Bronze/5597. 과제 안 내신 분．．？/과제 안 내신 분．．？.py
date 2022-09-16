check = [0] * 31
for _ in range(28):
    check[int(input())] = 1
for i in range(1, 31):
    if check[i] == 0:
        print(i)