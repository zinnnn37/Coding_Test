def sol():
    n = int(input())
    wood = 64
    length = 0
    cnt = 0
    while wood >= 1:
        if length + wood <= n:
            length += wood
            cnt += 1
        if length == n:
            print(cnt)
            break
        wood = wood // 2

sol()