def checker(w):
    cnt = 0
    for s in w:
        alpha = [0 for _ in range(26)]
        cnt += 1
        for i in range(len(s)):
            if (s[i] != s[i-1] and alpha[ord(s[i]) - 97] != 0):
                cnt -= 1
                break
            else:
                alpha[ord(s[i]) - 97] += 1
    print(cnt)

n = int(input())
word = list(input() for _ in range(n))
checker(word)