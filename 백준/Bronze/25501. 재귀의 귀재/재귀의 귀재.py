def rec(s, length, depth, cnt):
    if (length >= depth):
        print(1, end=' ')
        return cnt;
    elif s[length] != s[depth]:
        print(0, end=' ');
        return cnt;
    else:
        cnt = rec(s, length + 1, depth - 1, cnt + 1)
        return cnt
    
def is_palindrome(s):
    return rec(s, 0, len(s) - 1, 1)
    
def sol():
    for _ in range(int(input())):
        print(is_palindrome(input()))
    
sol()