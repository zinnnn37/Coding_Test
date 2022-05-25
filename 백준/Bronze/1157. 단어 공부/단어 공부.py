def count(w):
    cnt = [0 for _ in range(26)]
    for c in w:
        if (c >= 'A' and c <= 'Z'):
            cnt[ord(c) - 65] += 1
        else:
            cnt[ord(c) - 97] += 1
    if (cnt.count(max(cnt)) > 1):
        print("?")
    else:
        print(chr(65 + cnt.index(max(cnt))))

word = input()
count(word)
