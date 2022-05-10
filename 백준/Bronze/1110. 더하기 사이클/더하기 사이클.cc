#include <stdio.h>

int main() {
    int num, i, cnt = 0;
    scanf("%d", &num);
    i = num;

    while (1) {
        i = i % 10 * 10 + (i / 10 + i % 10) % 10;
        cnt += 1;
        if (num == i) break;
    }
    printf("%d", cnt);
    return 0;
}