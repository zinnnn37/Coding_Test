#include <stdio.h>
#define MAX 1000000;
int main() {
    int n, i = 0;
    int num, min, max;
    scanf("%d", &n);
    scanf("%d", &num);
    min = max = num;
    while (i < n -1) {
        scanf("%d", &num);
        if (min > num) min = num;
        if (max < num) max = num;
        i++;
    }
    printf("%d %d", min, max);
    return 0;
}