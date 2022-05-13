#include <stdio.h>

int main() {
    int n, i = 0;
    scanf("%d", &n);
    while (i < n) {
        int j = n;
        int k = 1;
        while (k < n-i) {
            printf(" ");
            k++;
        }
        j = n;
        while (j > n - i - 1) {
            printf("*");
            j--;
        }
        printf("\n");
        i++;
    }
    return 0;
}