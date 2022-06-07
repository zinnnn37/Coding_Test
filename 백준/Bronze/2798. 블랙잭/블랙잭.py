def blackJack(n, ans, res, cards, biggest, idx):
    if (n == 3):
        if (biggest < sum(ans) <= res):
            biggest = sum(ans)
        return biggest
    else:
        while (idx < len(cards)):
            ans.append(cards[idx])
            idx += 1 # 여기서 idx++ 했는데 재귀 안에서 또 해서 그럼..
            biggest = blackJack(n + 1, ans, res, cards, biggest, idx)
            ans.pop()
    return biggest

n, res = map(int, input().split())
cards = list(map(int, input().split()))
ans = []

print(blackJack(0, ans, res, cards, 0, 0))