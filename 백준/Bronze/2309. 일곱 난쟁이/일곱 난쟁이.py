# 다 더해서 둘만 뺐을 때 100이 되면 맞는 것
def check(lst):
    res = sum(lst)
    for i in range(9):
        for j in range(i+1, 9):
            if (res - lst[i] - lst[j] == 100):
                n, m = lst[i], lst[j]
                return (n, m)

# 9줄의 입력을 받아 리스트로 저장하기
lst = list(map(int, (input() for _ in range(9))))

n, m = check(lst)

lst.remove(n)
lst.remove(m)
lst.sort()

for i in lst:
    print(i)
