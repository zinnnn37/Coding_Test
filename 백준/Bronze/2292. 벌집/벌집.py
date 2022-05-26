def hive(n):
    cnt = total = 1
    while (True):
        if (n <= total):
            return cnt
        total += 6 * cnt
        cnt += 1

print(hive(int(input())))