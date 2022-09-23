import sys
input = lambda: sys.stdin.readline().strip()

def check_ascending(note):
    cur = note[0]
    for n in note[1:]:
        if n > cur:
            cur = n
        else:
            return False
    return True

def check_descending(note):
    cur = note[0]
    for n in note[1:]:
        if n < cur:
            cur = n
        else:
            return False
    return True

def sol():
    note = list(map(int, input().split()))
    ascending = check_ascending(note)
    descending = check_descending(note)
    if ascending:
        print('ascending')
    elif descending:
        print('descending')
    else:
        print('mixed')

sol()